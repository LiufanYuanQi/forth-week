package person.liufan.bookstore.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import person.liufan.bookstore.entity.Province;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/15
 */
@Repository
public interface ProvinceMapper extends JpaRepository<Province, Long>, JpaSpecificationExecutor<Province> {
    /**
     * 通过主键进行查询
     * @param provinceId id
     * @return 结果
     */
    @Query(value = "select id, name, alias, resource from think_province where id = ?1",nativeQuery = true)
    Province queryOne(Integer provinceId);
}