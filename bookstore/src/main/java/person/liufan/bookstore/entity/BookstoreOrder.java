package person.liufan.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 * 图书订单实体类
 */
@Data
@Entity
@Table(name = "tb_bookstore_order")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class BookstoreOrder {
    /**
     * 订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 订单所属用户的id
     */
    @Column(name = "tb_bookstore_order_user_id")
    private Long tbBookstoreOrderUserId;
    /**
     * 订单的所有金额
     */
    @Column(name = "tb_bookstore_order_total_money")
    private BigDecimal tbBookstoreOrderTotalMoney;
    /**
     * 订单的收货地址
     */
    @Column(name = "tb_bookstore_order_shipping_address")
    private String tbBookstoreOrderShippingAddress;
    /**
     * 创建时间
     */
    @Column(name = "tb_bookstore_order_create_time")
    private Date tbBookstoreOrderCreateTime;
    /**
     * 更新时间
     */
    @Column(name = "tb_bookstore_order_update_time")
    private Date tbBookstoreOrderUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTbBookstoreOrderUserId() {
        return tbBookstoreOrderUserId;
    }

    public void setTbBookstoreOrderUserId(Long tbBookstoreOrderUserId) {
        this.tbBookstoreOrderUserId = tbBookstoreOrderUserId;
    }

    public BigDecimal getTbBookstoreOrderTotalMoney() {
        return tbBookstoreOrderTotalMoney;
    }

    public void setTbBookstoreOrderTotalMoney(BigDecimal tbBookstoreOrderTotalMoney) {
        this.tbBookstoreOrderTotalMoney = tbBookstoreOrderTotalMoney;
    }

    public String getTbBookstoreOrderShippingAddress() {
        return tbBookstoreOrderShippingAddress;
    }

    public void setTbBookstoreOrderShippingAddress(String tbBookstoreOrderShippingAddress) {
        this.tbBookstoreOrderShippingAddress = tbBookstoreOrderShippingAddress;
    }

    public Date getTbBookstoreOrderCreateTime() {
        return tbBookstoreOrderCreateTime;
    }

    public void setTbBookstoreOrderCreateTime(Date tbBookstoreOrderCreateTime) {
        this.tbBookstoreOrderCreateTime = tbBookstoreOrderCreateTime;
    }

    public Date getTbBookstoreOrderUpdateTime() {
        return tbBookstoreOrderUpdateTime;
    }

    public void setTbBookstoreOrderUpdateTime(Date tbBookstoreOrderUpdateTime) {
        this.tbBookstoreOrderUpdateTime = tbBookstoreOrderUpdateTime;
    }

    @Override
    public String toString() {
        return "BookstoreOrder{" +
                "id=" + id +
                ", tbBookstoreOrderUserId=" + tbBookstoreOrderUserId +
                ", tbBookstoreOrderTotalMoney=" + tbBookstoreOrderTotalMoney +
                ", tbBookstoreOrderShippingAddress='" + tbBookstoreOrderShippingAddress + '\'' +
                ", tbBookstoreOrderCreateTime=" + tbBookstoreOrderCreateTime +
                ", tbBookstoreOrderUpdateTime=" + tbBookstoreOrderUpdateTime +
                '}';
    }
}