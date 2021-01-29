package person.liufan.bookstore.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import person.liufan.bookstore.entity.BookstoreAdmin;
import person.liufan.bookstore.entity.BookstoreShoppingCart;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * tb_bookstore_shopping_cart代理接口
 */
@Repository
public interface BookstoreShoppingCartMapper extends JpaRepository<BookstoreShoppingCart, Long>, JpaSpecificationExecutor<BookstoreShoppingCart> {

    /**
     * 通过用户id和图书id查询购物车中是否有这条记录
     * @param query 查询条件
     * @return 查询结果
     */
    @Query(value = "from BookstoreShoppingCart where tbBookstoreShoppingCartUserId =?1 and tbBookstoreShoppingCartBookId=?2 ")
    BookstoreShoppingCart selectByUserIdAndBookId(BookstoreShoppingCart query);


    /**
     * 通过ids查询记录
     * @param ids ids
     * @return 查询结果
     */
    @Query(value = "from BookstoreShoppingCart where id in ?1")
    List<BookstoreShoppingCart> selectByIds(String[] ids);
    /**
     * 通过id进行查询，如果id不存在则全表查询
     * @param cart id
     * @return 查询结果
     */
    @Query(value = "from BookstoreShoppingCart")
    List<BookstoreShoppingCart> listCartById(BookstoreShoppingCart cart);

    /**
     * 通过书本id删除记录
     * @param bookId 书本id
     */
    @Query(value = "delete from BookstoreShoppingCart where tbBookstoreShoppingCartBookId = ?1")
    void deleteByBookId(Long bookId);

}