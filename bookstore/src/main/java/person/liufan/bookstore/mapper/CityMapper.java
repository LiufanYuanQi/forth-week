package person.liufan.bookstore.mapper;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import person.liufan.bookstore.entity.BookstoreAdmin;
import person.liufan.bookstore.entity.City;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/15
 */
@Repository
public interface CityMapper extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {

    /**
     * 通过省份id查询所有的城市
     * @param provinceId 省份的id
     * @return 查询到的所有城市实体集合
     */
    @Query(value = "from City where provinceId = ?1")
    List<City> listCityByProvince(Long provinceId);
}