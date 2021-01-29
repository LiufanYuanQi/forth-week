package person.liufan.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 订单关联商品id实体类
 */
@Data
@Entity
@Table(name = "tb_bookstore_order_tbsc")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class BookstoreOrderShoppingCart {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 关联的订单id
     */
    @Column(name = "tb_bookstore_order_tbsc_order_id")
    private Long tbBookstoreOrderTbscOrderId;
    /**
     * 该订单中存在的图书id
     */
    @Column(name = "tb_bookstore_order_tbsc_book_id")
    private Long tbBookstoreOrderTbscBookId;
    /**
     * 该订单中存在的图书总数
     */
    @Column(name = "tb_bookstore_order_tbsc_book_count")
    private Integer tbBookstoreOrderTbscBookCount;
    /**
     * 创建时间
     */
    @Column(name = "tb_bookstore_order_tbsc_create_time")
    private Date tbBookstoreOrderTbscCreateTime;
    /**
     * 修改时间
     */
    @Column(name = "tb_bookstore_order_tbsc_update_time")
    private Date tbBookstoreOrderTbscUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTbBookstoreOrderTbscBookId() {
        return tbBookstoreOrderTbscBookId;
    }

    public void setTbBookstoreOrderTbscBookId(Long tbBookstoreOrderTbscBookId) {
        this.tbBookstoreOrderTbscBookId = tbBookstoreOrderTbscBookId;
    }

    public Integer getTbBookstoreOrderTbscBookCount() {
        return tbBookstoreOrderTbscBookCount;
    }

    public void setTbBookstoreOrderTbscBookCount(Integer tbBookstoreOrderTbscBookCount) {
        this.tbBookstoreOrderTbscBookCount = tbBookstoreOrderTbscBookCount;
    }

    public Date getTbBookstoreOrderTbscCreateTime() {
        return tbBookstoreOrderTbscCreateTime;
    }

    public void setTbBookstoreOrderTbscCreateTime(Date tbBookstoreOrderTbscCreateTime) {
        this.tbBookstoreOrderTbscCreateTime = tbBookstoreOrderTbscCreateTime;
    }

    public Date getTbBookstoreOrderTbscUpdateTime() {
        return tbBookstoreOrderTbscUpdateTime;
    }

    public void setTbBookstoreOrderTbscUpdateTime(Date tbBookstoreOrderTbscUpdateTime) {
        this.tbBookstoreOrderTbscUpdateTime = tbBookstoreOrderTbscUpdateTime;
    }

    public Long getTbBookstoreOrderTbscOrderId() {
        return tbBookstoreOrderTbscOrderId;
    }

    public void setTbBookstoreOrderTbscOrderId(Long tbBookstoreOrderTbscOrderId) {
        this.tbBookstoreOrderTbscOrderId = tbBookstoreOrderTbscOrderId;
    }

    @Override
    public String toString() {
        return "BookstoreOrderShoppingCart{" +
                "id=" + id +
                ", tbBookstoreOrderTbscOrderId=" + tbBookstoreOrderTbscOrderId +
                ", tbBookstoreOrderTbscBookId=" + tbBookstoreOrderTbscBookId +
                ", tbBookstoreOrderTbscBookCount=" + tbBookstoreOrderTbscBookCount +
                ", tbBookstoreOrderTbscCreateTime=" + tbBookstoreOrderTbscCreateTime +
                ", tbBookstoreOrderTbscUpdateTime=" + tbBookstoreOrderTbscUpdateTime +
                '}';
    }
}