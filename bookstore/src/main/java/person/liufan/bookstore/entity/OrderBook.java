package person.liufan.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_bookstore_order_book")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class OrderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tb_bookstore_book_name")
    private String tbBookstoreBookName;
    @Column(name = "tb_bookstore_book_author")
    private String tbBookstoreBookAuthor;
    @Column(name = "tb_bookstore_book_publishing")
    private String tbBookstoreBookPublishing;
    @Column(name = "tb_bookstore_book_price")
    private BigDecimal tbBookstoreBookPrice;
    @Column(name = "tb_bookstore_book_number")
    private Integer tbBookstoreBookNumber;
    @Column(name = "tb_bookstore_book_info")
    private String tbBookstoreBookInfo;
    @Column(name = "tb_bookstore_book_picture_url")
    private String tbBookstoreBookPictureUrl;
    @Column(name = "tb_bookstore_book_create_time")
    private Date tbBookstoreBookCreateTime;
    @Column(name = "tb_bookstore_book_update_time")
    private Date tbBookstoreBookUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTbBookstoreBookName() {
        return tbBookstoreBookName;
    }

    public void setTbBookstoreBookName(String tbBookstoreBookName) {
        this.tbBookstoreBookName = tbBookstoreBookName;
    }

    public String getTbBookstoreBookAuthor() {
        return tbBookstoreBookAuthor;
    }

    public void setTbBookstoreBookAuthor(String tbBookstoreBookAuthor) {
        this.tbBookstoreBookAuthor = tbBookstoreBookAuthor;
    }

    public String getTbBookstoreBookPublishing() {
        return tbBookstoreBookPublishing;
    }

    public void setTbBookstoreBookPublishing(String tbBookstoreBookPublishing) {
        this.tbBookstoreBookPublishing = tbBookstoreBookPublishing;
    }

    public BigDecimal getTbBookstoreBookPrice() {
        return tbBookstoreBookPrice;
    }

    public void setTbBookstoreBookPrice(BigDecimal tbBookstoreBookPrice) {
        this.tbBookstoreBookPrice = tbBookstoreBookPrice;
    }

    public Integer getTbBookstoreBookNumber() {
        return tbBookstoreBookNumber;
    }

    public void setTbBookstoreBookNumber(Integer tbBookstoreBookNumber) {
        this.tbBookstoreBookNumber = tbBookstoreBookNumber;
    }

    public String getTbBookstoreBookInfo() {
        return tbBookstoreBookInfo;
    }

    public void setTbBookstoreBookInfo(String tbBookstoreBookInfo) {
        this.tbBookstoreBookInfo = tbBookstoreBookInfo;
    }

    public String getTbBookstoreBookPictureUrl() {
        return tbBookstoreBookPictureUrl;
    }

    public void setTbBookstoreBookPictureUrl(String tbBookstoreBookPictureUrl) {
        this.tbBookstoreBookPictureUrl = tbBookstoreBookPictureUrl;
    }

    public Date getTbBookstoreBookCreateTime() {
        return tbBookstoreBookCreateTime;
    }

    public void setTbBookstoreBookCreateTime(Date tbBookstoreBookCreateTime) {
        this.tbBookstoreBookCreateTime = tbBookstoreBookCreateTime;
    }

    public Date getTbBookstoreBookUpdateTime() {
        return tbBookstoreBookUpdateTime;
    }

    public void setTbBookstoreBookUpdateTime(Date tbBookstoreBookUpdateTime) {
        this.tbBookstoreBookUpdateTime = tbBookstoreBookUpdateTime;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "id=" + id +
                ", tbBookstoreBookName='" + tbBookstoreBookName + '\'' +
                ", tbBookstoreBookAuthor='" + tbBookstoreBookAuthor + '\'' +
                ", tbBookstoreBookPublishing='" + tbBookstoreBookPublishing + '\'' +
                ", tbBookstoreBookPrice=" + tbBookstoreBookPrice +
                ", tbBookstoreBookNumber=" + tbBookstoreBookNumber +
                ", tbBookstoreBookInfo='" + tbBookstoreBookInfo + '\'' +
                ", tbBookstoreBookPictureUrl='" + tbBookstoreBookPictureUrl + '\'' +
                ", tbBookstoreBookCreateTime=" + tbBookstoreBookCreateTime +
                ", tbBookstoreBookUpdateTime=" + tbBookstoreBookUpdateTime +
                '}';
    }
}