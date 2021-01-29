package person.liufan.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 管理员实体类
 */
@Data
@Entity
@Table(name = "tb_bookstore_admin")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class BookstoreAdmin {
    /**
     * 管理员id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 管理员名字
     */
    @Column(name = "tb_bookstore_admin_name")
    private String tbBookstoreAdminName;
    /**
     * 管理员密码
     */
    @Column(name = "tb_bookstore_admin_password")
    private String tbBookstoreAdminPassword;
    /**
     * 创建时间
     */
    @Column(name = "tb_bookstore_admin_create_time")
    private Date tbBookstoreAdminCreateTime;
    /**
     * 更新时间
     */
    @Column(name = "tb_bookstore_admin_update_time")
    private Date tbBookstoreAdminUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTbBookstoreAdminName() {
        return tbBookstoreAdminName;
    }

    public void setTbBookstoreAdminName(String tbBookstoreAdminName) {
        this.tbBookstoreAdminName = tbBookstoreAdminName;
    }

    public String getTbBookstoreAdminPassword() {
        return tbBookstoreAdminPassword;
    }

    public void setTbBookstoreAdminPassword(String tbBookstoreAdminPassword) {
        this.tbBookstoreAdminPassword = tbBookstoreAdminPassword;
    }

    public Date getTbBookstoreAdminCreateTime() {
        return tbBookstoreAdminCreateTime;
    }

    public void setTbBookstoreAdminCreateTime(Date tbBookstoreAdminCreateTime) {
        this.tbBookstoreAdminCreateTime = tbBookstoreAdminCreateTime;
    }

    public Date getTbBookstoreAdminUpdateTime() {
        return tbBookstoreAdminUpdateTime;
    }

    public void setTbBookstoreAdminUpdateTime(Date tbBookstoreAdminUpdateTime) {
        this.tbBookstoreAdminUpdateTime = tbBookstoreAdminUpdateTime;
    }

    @Override
    public String toString() {
        return "BookstoreAdmin{" +
                "id=" + id +
                ", tbBookstoreAdminName='" + tbBookstoreAdminName + '\'' +
                ", tbBookstoreAdminPassword='" + tbBookstoreAdminPassword + '\'' +
                ", tbBookstoreAdminCreateTime=" + tbBookstoreAdminCreateTime +
                ", tbBookstoreAdminUpdateTime=" + tbBookstoreAdminUpdateTime +
                '}';
    }
}