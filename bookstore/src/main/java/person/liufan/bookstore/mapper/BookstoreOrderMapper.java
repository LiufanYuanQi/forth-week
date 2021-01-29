package person.liufan.bookstore.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import person.liufan.bookstore.entity.BookstoreAdmin;
import person.liufan.bookstore.entity.BookstoreOrder;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * tb_bookstore_order订单表代理接口
 */
@Repository
public interface BookstoreOrderMapper extends JpaRepository<BookstoreOrder, Long>, JpaSpecificationExecutor<BookstoreOrder> {

    /**
     * 通过id和用户id查询订单记录
     * @param order 查询条件
     * @return 查询结果
     */
    @Query(value = "from BookstoreOrder")
    List<BookstoreOrder> listOrderById(BookstoreOrder order);
}