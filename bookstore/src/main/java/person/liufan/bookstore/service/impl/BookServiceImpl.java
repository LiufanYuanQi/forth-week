package person.liufan.bookstore.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.entity.BookstoreBook;
import person.liufan.bookstore.entity.BookstoreUser;
import person.liufan.bookstore.mapper.BookstoreBookMapper;
import person.liufan.bookstore.mapper.BookstoreShoppingCartMapper;
import person.liufan.bookstore.service.BookService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/19
 */
@Component
public class BookServiceImpl implements BookService {
    @Resource
    private BookstoreBookMapper bookMapper;
    @Resource
    private BookstoreShoppingCartMapper cartMapper;
    @Override
    public Boolean sava(BookstoreBook bookstoreBook) {
        BookstoreBook rest = bookMapper.selectByName(bookstoreBook.getTbBookstoreBookName());
        if (rest != null) {
            return false;
        }
        bookMapper.save(bookstoreBook);
        return true;
    }

    @Override
    public Map listBookDetailByName(Long id, int pageNum, int pageSize) {
        List<BookstoreBook> list = null;
        if (id != null) {
            list = bookMapper.listBookById(id, (pageNum-1)*pageSize, pageNum*pageSize);
        } else {
            list = bookMapper.listBook((pageNum-1)*pageSize, pageNum*pageSize);
        }
        Long count = bookMapper.count();
        Map map = new HashMap(4);
        map.put(MyConstant.LIST, list);
        map.put(MyConstant.COUNT, count);
        return map;
    }

    @Override
    public BookstoreBook selectById(Long bookId) {
        return bookMapper.getOne(bookId);
    }

    @Override
    public boolean updateById(BookstoreBook book) {
        BookstoreBook rest = bookMapper.getOne(book.getId());
        book.setTbBookstoreBookCreateTime(rest.getTbBookstoreBookCreateTime());
        bookMapper.save(book);
        return true;
    }

    @Override
    public Boolean deleteUserByIds(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            bookMapper.deleteById(Long.valueOf(ids[i]));
            /*cartMapper.deleteByBookId(Long.valueOf(ids[i]));*/
        }
        return true;
    }
}
