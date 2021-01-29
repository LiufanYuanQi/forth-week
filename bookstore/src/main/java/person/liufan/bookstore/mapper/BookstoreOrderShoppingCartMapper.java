package person.liufan.bookstore.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import person.liufan.bookstore.entity.BookstoreAdmin;
import person.liufan.bookstore.entity.BookstoreOrderShoppingCart;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * tb_bookstore_order_tbsc代理接口
 */
@Repository
public interface BookstoreOrderShoppingCartMapper extends JpaRepository<BookstoreOrderShoppingCart, Long>, JpaSpecificationExecutor<BookstoreOrderShoppingCart> {


    /**
     * 通过订单号查询所有的订单详情
     * @param id id
     * @return 查询结果
     */
    @Query(value = "from BookstoreOrderShoppingCart where tbBookstoreOrderTbscOrderId = ?1")
    List<BookstoreOrderShoppingCart> listByOrderId(Long id);
}