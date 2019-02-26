package Lesson17;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "OFFICES", schema = "MA_STUDENT")
public class Office implements Serializable {

    @Id
    @Column(name = "OFFICE")
    private BigDecimal officeId;
    @Column
    private String city;
    @Column
    private String region;
    @Column
    private BigDecimal mgr;
    @Column
    private BigDecimal target;
    @Column
    private BigDecimal sales;

    public Office() {
    }

    public Office(BigDecimal office, String city, String region, BigDecimal mgr, BigDecimal target, BigDecimal sales) {
        this.officeId = office;
        this.city = city;
        this.region = region;
        this.mgr = mgr;
        this.target = target;
        this.sales = sales;
    }

    public BigDecimal getOfficeId() {
        return officeId;
    }

    public void setOfficeId(BigDecimal officeId) {
        this.officeId = officeId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getMgr() {
        return mgr;
    }

    public void setMgr(BigDecimal mgr) {
        this.mgr = mgr;
    }

    public BigDecimal getTarget() {
        return target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeId=" + officeId +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", mgr=" + mgr +
                ", target=" + target +
                ", sales=" + sales +
                '}';
    }
}
