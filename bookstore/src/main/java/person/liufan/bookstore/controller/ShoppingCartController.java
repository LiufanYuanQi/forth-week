package person.liufan.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.liufan.bookstore.entity.BookstoreBook;
import person.liufan.bookstore.entity.BookstoreShoppingCart;
import person.liufan.bookstore.util.Rest;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/28
 */
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    @RequestMapping("/save/list")
    public Rest saveList(String  addList) {
        System.out.println(addList);
        return Rest.ok();
    }
    @RequestMapping("/save/one")
    public Rest saveOne(BookstoreShoppingCart cart) {
        System.out.println(cart);
        return Rest.ok();
    }
    @RequestMapping("/query/one")
    public Rest queryOne(Long id) {
        System.out.println(id);
        return Rest.ok();
    }

    @RequestMapping("/update")
    public Rest update(BookstoreShoppingCart cart) {
        System.out.println(cart);
        return Rest.ok();
    }

    @RequestMapping("/delete")
    public Rest delete(String deleteList) {
        System.out.println(deleteList);
        return Rest.ok();
    }


    @RequestMapping("/order")
    public Rest getOrder(String shoppingCartList) {
        System.out.println(shoppingCartList);
        return Rest.ok();
    }
    @RequestMapping("/query/all")
    public Rest queryAll(Long id, Integer pageNum, Integer pageSize) {
        System.out.println(id);
        System.out.println(pageNum);
        System.out.println(pageSize);
        return Rest.ok();
    }

}
