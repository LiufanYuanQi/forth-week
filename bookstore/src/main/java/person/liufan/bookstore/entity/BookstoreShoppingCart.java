package person.liufan.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 购物车记录实体类
 */
@Data
@Entity
@Table(name = "tb_bookstore_shopping_cart")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class BookstoreShoppingCart {
    /**
     * 购物车记录id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 购物车的用户id
     */
    @Column(name = "tb_bookstore_shopping_cart_user_id")
    private Long tbBookstoreShoppingCartUserId;
    /**
     * 购物车的图书id
     */
    @Column(name = "tb_bookstore_shopping_cart_book_id")
    private Long tbBookstoreShoppingCartBookId;
    /**
     * 购物车的图书总数
     */
    @Column(name = "tb_bookstore_shopping_cart_book_count")
    private Integer tbBookstoreShoppingCartBookCount;
    /**
     * 创建时间
     */
    @Column(name = "tb_bookstore_shopping_cart_create_time")
    private Date tbBookstoreShoppingCartCreateTime;
    /**
     * 修改时间
     */
    @Column(name = "tb_bookstore_shopping_cart_update_time")
    private Date tbBookstoreShoppingCartUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTbBookstoreShoppingCartUserId() {
        return tbBookstoreShoppingCartUserId;
    }

    public void setTbBookstoreShoppingCartUserId(Long tbBookstoreShoppingCartUserId) {
        this.tbBookstoreShoppingCartUserId = tbBookstoreShoppingCartUserId;
    }

    public Long getTbBookstoreShoppingCartBookId() {
        return tbBookstoreShoppingCartBookId;
    }

    public void setTbBookstoreShoppingCartBookId(Long tbBookstoreShoppingCartBookId) {
        this.tbBookstoreShoppingCartBookId = tbBookstoreShoppingCartBookId;
    }

    public Integer getTbBookstoreShoppingCartBookCount() {
        return tbBookstoreShoppingCartBookCount;
    }

    public void setTbBookstoreShoppingCartBookCount(Integer tbBookstoreShoppingCartBookCount) {
        this.tbBookstoreShoppingCartBookCount = tbBookstoreShoppingCartBookCount;
    }

    public Date getTbBookstoreShoppingCartCreateTime() {
        return tbBookstoreShoppingCartCreateTime;
    }

    public void setTbBookstoreShoppingCartCreateTime(Date tbBookstoreShoppingCartCreateTime) {
        this.tbBookstoreShoppingCartCreateTime = tbBookstoreShoppingCartCreateTime;
    }

    public Date getTbBookstoreShoppingCartUpdateTime() {
        return tbBookstoreShoppingCartUpdateTime;
    }

    public void setTbBookstoreShoppingCartUpdateTime(Date tbBookstoreShoppingCartUpdateTime) {
        this.tbBookstoreShoppingCartUpdateTime = tbBookstoreShoppingCartUpdateTime;
    }

    @Override
    public String toString() {
        return "BookstoreShoppingCart{" +
                "id=" + id +
                ", tbBookstoreShoppingCartUserId=" + tbBookstoreShoppingCartUserId +
                ", tbBookstoreShoppingCartBookId=" + tbBookstoreShoppingCartBookId +
                ", tbBookstoreShoppingCartBookCount=" + tbBookstoreShoppingCartBookCount +
                ", tbBookstoreShoppingCartCreateTime=" + tbBookstoreShoppingCartCreateTime +
                ", tbBookstoreShoppingCartUpdateTime=" + tbBookstoreShoppingCartUpdateTime +
                '}';
    }
}