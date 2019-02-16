package Lesson15;

import java.math.BigDecimal;

public class Office {

    private BigDecimal officeId;
    private String city;
    private String region;
    private BigDecimal mgr;
    private BigDecimal target;
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
