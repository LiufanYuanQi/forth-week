package person.liufan.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/15
 * hai_location实体类，保存城市信息
 */
@Data
@Entity
@Table(name = "hai_location")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class City {
    /**
     * 城市id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 国家编号
     */
    @Column(name = "country")
    private String country;
    /**
     * 省份id
     */
    @Column(name = "province_id")
    private Long provinceId;
    /**
     * 省份名称
     */
    @Column(name = "state")
    private String state;
    /**
     * 城市名称
     */
    @Column(name = "city")
    private String city;
    /**
     * 城市ASCII码
     */
    @Column(name = "cityASCII")
    private String cityascii;
    /**
     * 是否是资源城市
     */
    @Column(name = "resource")
    private Integer resource;
    /**
     * 排序编号
     */
    @Column(name = "sort")
    private Integer sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityascii() {
        return cityascii;
    }

    public void setCityascii(String cityascii) {
        this.cityascii = cityascii;
    }

    public Integer getResource() {
        return resource;
    }

    public void setResource(Integer resource) {
        this.resource = resource;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}