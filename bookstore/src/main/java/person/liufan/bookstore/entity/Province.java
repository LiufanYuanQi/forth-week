package person.liufan.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.beans.Transient;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/15
 * think_province实体类，保存省份信息
 */
@Data
@Entity
@Table(name = "think_province")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Province {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 省份名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 区域名称
     */
    @Column(name = "alias")
    private String alias;
    /**
     * 是否是资源城市
     */
    @Column(name = "resource")
    private Byte resource;
    /**
     * 省份所有的城市
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Byte getResource() {
        return resource;
    }

    public void setResource(Byte resource) {
        this.resource = resource;
    }

}