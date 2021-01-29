package person.liufan.bookstore.service.impl;

import org.springframework.stereotype.Component;
import person.liufan.bookstore.entity.BookstoreBook;
import person.liufan.bookstore.entity.BookstoreShoppingCart;
import person.liufan.bookstore.mapper.BookstoreBookMapper;
import person.liufan.bookstore.mapper.BookstoreShoppingCartMapper;
import person.liufan.bookstore.service.ShoppingCartService;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/20
 */
@Component
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private BookstoreShoppingCartMapper cartMapper;
    @Resource
    private BookstoreBookMapper bookMapper;
    @Override
    public Map addToCartByBookId(String[] ids,Long userId) {
        Map map = new HashMap(4);
        boolean flag = false;
        String message = "全部添加成功";
        for (int i = 0; i < ids.length; i++) {
            BookstoreShoppingCart query = new BookstoreShoppingCart();
            query.setTbBookstoreShoppingCartUserId(userId);
            query.setTbBookstoreShoppingCartBookId(Long.valueOf(ids[i]));
            query.setTbBookstoreShoppingCartBookCount(1);
            query.setTbBookstoreShoppingCartCreateTime(new Date());
            BookstoreShoppingCart cart = cartMapper.selectByUserIdAndBookId(query);
            if (cart == null) {
                cartMapper.save(query);
                flag = true;
            } else {
                message = "部分商品已在购物车中，将剩余部分添加到购物车";
            }
        }
        if (flag) {
            map.put("flag", true);
            map.put("message", message);
            return map;
        }
        map.put("flag", false);
        map.put("message", "所有商品都在购物车中");
        return map;
    }

    @Override
    public Boolean sava(BookstoreShoppingCart cart) {
        BookstoreShoppingCart rest = cartMapper.selectByUserIdAndBookId(cart);
        if (rest == null) {
            cartMapper.save(cart);
            return true;
        }
        return false;
    }

    @Override
    public BookstoreShoppingCart selectById(Long cartId) {
        return cartMapper.getOne(cartId);
    }

    @Override
    public boolean updateById(BookstoreShoppingCart cart) {
        cartMapper.save(cart);
        return true;
    }

    @Override
    public Boolean deleteCartByIds(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            cartMapper.deleteById(Long.valueOf(ids[i]));
        }
        return true;
    }

    @Override
    public Map createOrderByIds(String[] ids) {
        List<BookstoreShoppingCart> carts = cartMapper.selectByIds(ids);
        List cartList = new ArrayList();
        List messageList = new ArrayList();
        for (BookstoreShoppingCart cart : carts) {
            BookstoreBook book = bookMapper.getOne(cart.getTbBookstoreShoppingCartBookId());
            if (cart.getTbBookstoreShoppingCartBookCount() <= book.getTbBookstoreBookNumber()) {
                cartList.add(cart);
            } else {
                messageList.add(book.getTbBookstoreBookName());
            }
        }
        Map map = new HashMap(4);
        map.put("cartList", cartList);
        map.put("message", messageList);
        return map;
    }

    @Override
    public Map listCartDetailByName(Long id,Long userId, int pageNum, int pageSize) {
        BookstoreShoppingCart cart = new BookstoreShoppingCart();
        cart.setId(id);
        cart.setTbBookstoreShoppingCartUserId(userId);
        List<BookstoreShoppingCart> list = cartMapper.listCartById(cart);

        return null;
    }
}
