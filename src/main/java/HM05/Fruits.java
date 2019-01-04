package HM05;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Fruits {
    //  private String type;

    private int price;
    private LocalDate localDate;
    private int storageTime;
    private KindsOfFruits kinds;

    public Fruits(int price, LocalDate localDate, int storageTime, KindsOfFruits kinds) {
        this.price = price;
        this.localDate = localDate;
        this.storageTime = storageTime;
        this.kinds = kinds;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getStorageTime() {
        return storageTime;
    }

    public KindsOfFruits getKinds() {
        return kinds;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    boolean shelfLife(LocalDate date) {
        return date.isAfter(localDate) && DAYS.between(localDate, date) <= storageTime;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "price=" + price +
                ", localDate=" + localDate +
                ", storageTime=" + storageTime +
                ", kinds=" + kinds +
                '}';
    }
}
