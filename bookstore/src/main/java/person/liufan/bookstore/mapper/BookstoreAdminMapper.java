package person.liufan.bookstore.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import person.liufan.bookstore.entity.BookstoreAdmin;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * tb_bookstore_admin管理员用户表代理接口
 */
@Repository
public interface BookstoreAdminMapper extends JpaRepository<BookstoreAdmin, Long>, JpaSpecificationExecutor<BookstoreAdmin> {

    /**
     * 通过名字查询admin
     * @param tbBookstoreAdminName admin名字
     * @return 查询结果
     */
    @Query(value = "from BookstoreAdmin where tbBookstoreAdminName = ?1")
    BookstoreAdmin selectByName(String tbBookstoreAdminName);
}