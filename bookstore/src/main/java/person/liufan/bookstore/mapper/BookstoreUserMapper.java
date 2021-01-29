package person.liufan.bookstore.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import person.liufan.bookstore.entity.BookstoreAdmin;
import person.liufan.bookstore.entity.BookstoreUser;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * tb_bookstore_user代理接口
 */
@Repository
public interface BookstoreUserMapper extends JpaRepository<BookstoreUser, Long>, JpaSpecificationExecutor<BookstoreUser> {

    /**
     * 通过名字查询记录
     *
     * @param userName 用户名
     * @return 查询结果
     */
    @Query(value = "from BookstoreUser where tbBookstoreUserName = ?1")
    BookstoreUser selectByName(String userName);

    /**
     * 通过id进行查询，如果id为空则全表查询
     *
     * @param id id
     * @param start start
     * @param end end
     * @return 查询结果
     */
    @Query(value = "select id, tb_bookstore_user_name, tb_bookstore_user_password, tb_bookstore_user_real_name, \n" +
            "    tb_bookstore_user_phone, tb_bookstore_user_email, tb_bookstore_user_city_id, tb_bookstore_user_address, \n" +
            "    tb_bookstore_user_hobby, tb_bookstore_user_create_time, tb_bookstore_user_update_time" +
            " from tb_bookstore_user where id = ?1 limit ?2,?3",nativeQuery = true)
    List<BookstoreUser> listUserById(Long id, int start, int end);

    /**
     * 分页查询
     * @param start start
     * @param end end
     * @return 查询结果
     */
    @Query(value = "select id, tb_bookstore_user_name, tb_bookstore_user_password, tb_bookstore_user_real_name, \n" +
            "    tb_bookstore_user_phone, tb_bookstore_user_email, tb_bookstore_user_city_id, tb_bookstore_user_address, \n" +
            "    tb_bookstore_user_hobby, tb_bookstore_user_create_time, tb_bookstore_user_update_time" +
            " from tb_bookstore_user limit ?1,?2",nativeQuery = true)
    List<BookstoreUser> listUser(int start, int end);
}
