package Lesson17;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ORDERS", schema = "MA_STUDENT")
public class Order implements Serializable {

    @Id
    @Column(name = "ORDER_NUM")
    private BigDecimal orderNum;
    @Column
    private String product;
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;
    @Column
    private String mfr;
    @Column
    private BigDecimal qty;
    @Column
    private BigDecimal amount;

    public Order() {

    }

    public Order(BigDecimal orderNum, String product) {
        this.orderNum = orderNum;
        this.product = product;
    }

    public Order(BigDecimal orderNum, String product, Date orderDate, String mfr, BigDecimal qty, BigDecimal amount) {
        this.orderNum = orderNum;
        this.product = product;
        this.orderDate = orderDate;
        this.mfr = mfr;
        this.qty = qty;
        this.amount = amount;
    }

    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }


    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum=" + orderNum +
                ", product=" + product +
                ", orderDate=" + orderDate +
                ", mfr='" + mfr + '\'' +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }
}


