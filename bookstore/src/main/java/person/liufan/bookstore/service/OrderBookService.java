package person.liufan.bookstore.service;

import person.liufan.bookstore.entity.OrderBook;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/21
 */
public interface OrderBookService {
    /**
     * 通过主键查询书籍信息
     * @param tbBookstoreOrderTbscBookId
     * @return
     */
    OrderBook selectById(Long tbBookstoreOrderTbscBookId);

}
