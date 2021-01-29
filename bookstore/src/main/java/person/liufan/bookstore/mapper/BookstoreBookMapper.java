package person.liufan.bookstore.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import person.liufan.bookstore.entity.BookstoreAdmin;
import person.liufan.bookstore.entity.BookstoreBook;
import person.liufan.bookstore.entity.BookstoreShoppingCart;
import person.liufan.bookstore.entity.BookstoreUser;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * tb_bookstore_book管理员用户表代理接口
 */
@Repository
public interface BookstoreBookMapper extends JpaRepository<BookstoreBook, Long>, JpaSpecificationExecutor<BookstoreBook> {

    /**
     * 通过书名进行查询
     * @param tbBookstoreBookName 书名
     * @return 查询结果
     */
    @Query(value = "from BookstoreBook where tbBookstoreBookName = ?1")
    BookstoreBook selectByName(String tbBookstoreBookName);

    /**
     * 通过id进行查询，id没有全表查询
     *
     * @param id id
     * @param start start
     * @param end end
     * @return 查询结果
     */
    @Query(value = "select id, tb_bookstore_book_name, tb_bookstore_book_author, tb_bookstore_book_publishing, \n" +
            "    tb_bookstore_book_price, tb_bookstore_book_number, tb_bookstore_book_info, tb_bookstore_book_picture_url, \n" +
            "    tb_bookstore_book_create_time, tb_bookstore_book_update_time" +
            " from tb_bookstore_book where id = ?1 limit ?2,?3",nativeQuery = true)
    List<BookstoreBook> listBookById(Long id, Integer start, Integer end);

    /**
     * 分页查询
     * @param start start
     * @param end pageSize
     * @return end
     */
    @Query(value = "select id, tb_bookstore_book_name, tb_bookstore_book_author, tb_bookstore_book_publishing, \n" +
            "    tb_bookstore_book_price, tb_bookstore_book_number, tb_bookstore_book_info, tb_bookstore_book_picture_url, \n" +
            "    tb_bookstore_book_create_time, tb_bookstore_book_update_time" +
            " from tb_bookstore_book limit ?1,?2",nativeQuery = true)
    List<BookstoreBook> listBook(int start, int end);
}