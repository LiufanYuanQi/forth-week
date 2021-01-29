package person.liufan.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.liufan.bookstore.entity.BookstoreOrder;
import person.liufan.bookstore.util.Rest;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/28
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @RequestMapping("/save")
    public Rest save(String orderCartList, BookstoreOrder order) {
        System.out.println(orderCartList + order);
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
