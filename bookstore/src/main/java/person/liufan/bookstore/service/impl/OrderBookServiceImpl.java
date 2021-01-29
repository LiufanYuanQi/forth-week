package person.liufan.bookstore.service.impl;

import org.springframework.stereotype.Component;
import person.liufan.bookstore.entity.OrderBook;
import person.liufan.bookstore.mapper.OrderBookMapper;
import person.liufan.bookstore.service.OrderBookService;

import javax.annotation.Resource;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/21
 */
@Component
public class OrderBookServiceImpl implements OrderBookService {
    @Resource
    private OrderBookMapper orderBookMapper;

    @Override
    public OrderBook selectById(Long tbBookstoreOrderTbscBookId) {
        return orderBookMapper.getOne(tbBookstoreOrderTbscBookId);
    }
}
