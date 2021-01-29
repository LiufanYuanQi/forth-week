package person.liufan.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.entity.BookstoreBook;
import person.liufan.bookstore.service.BookService;
import person.liufan.bookstore.util.Rest;

import java.util.Date;
import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/28
 * 用于处理图书相关的请求
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/save")
    public Rest save(BookstoreBook book) {
        book.setTbBookstoreBookCreateTime(new Date());
        Boolean flag = bookService.sava(book);
        return Rest.ok().put(MyConstant.LOGIN_FLAG, flag);
    }

    @RequestMapping("/query/one")
    public Rest queryOne(Long id) {
        BookstoreBook book = bookService.selectById(id);
        return Rest.ok().put(MyConstant.DATA,book);
    }

    @RequestMapping("/update")
    public Rest update(BookstoreBook book) {
        book.setTbBookstoreBookUpdateTime(new Date());
        boolean flag = bookService.updateById(book);
        return Rest.ok().put(MyConstant.DATA,flag);
    }

    @RequestMapping("/delete")
    public Rest delete(String  deleteList) {
        String[] ids = deleteList.split("&");
        Boolean flag = bookService.deleteUserByIds(ids);
        return Rest.ok().put(MyConstant.DATA,flag);
    }

    @RequestMapping("/query/all")
    public Rest queryAll(Long id, Integer pageNum, Integer pageSize) {
        Map map = bookService.listBookDetailByName(id, pageNum, pageSize);
        return Rest.ok().put(MyConstant.DATA, map);
    }

}
