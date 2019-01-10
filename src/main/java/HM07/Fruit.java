package HM07;

import HM06.FruitType;
import HM06.Vitamins;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Fruit implements Serializable {


    private FruitType fruitType;

    private int dayToLive;

    private LocalDate deliveryDate;

    private int price;

    private List<Vitamins> vitamins;


    public Fruit(FruitType fruitType, int dayToLive, LocalDate deliveryDate, int price, List<Vitamins> vitamins) {

        this.fruitType = fruitType;

        this.dayToLive = dayToLive;

        this.deliveryDate = deliveryDate;

        this.price = price;

        this.vitamins = vitamins;

    }
    //Make methods that returns Exceptions

    public int dividePrice(int i) {
        int newPrice = 0;
        try {
            newPrice = getPrice() / i;

        } catch (ArithmeticException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println("Divide to 0");
        }
        return newPrice;
    }

    public int dividePrice2(int value) throws RuntimeException {
        return getPrice() / value;
    }

    public static String methodCheckedException() {
        String s = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s = reader.readLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

    //clone List<Fruit>
    public static List<Fruit> toMakeGMOfruit(List<Fruit> fruit) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(fruit);
        oos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);

        return (List<Fruit>) ois.readObject();
    }

    public String getPriceAndType() {
        return getFruitType() + " " + getPrice();
    }

    public FruitType getFruitType() {
        return fruitType;
    }


    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }


    public int getDayToLive() {
        return dayToLive;
    }


    public void setDayToLive(int dayToLive) {
        this.dayToLive = dayToLive;
    }


    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }


    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public List<Vitamins> getVitamins() {
        return vitamins;
    }


    public void setVitamins(List<Vitamins> vitamins) {
        this.vitamins = vitamins;
    }


    @Override

    public String toString() {

        return "Fruit [fruitType=" + fruitType + ", dayToLive=" + dayToLive + ", deliveryDate=" + deliveryDate

                + ", price=" + price + ", vitamins=" + vitamins + "]";

    }


    @Override

    public int hashCode() {

        final int prime = 31;

        int result = 1;

        result = prime * result + dayToLive;

        result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());

        result = prime * result + ((fruitType == null) ? 0 : fruitType.hashCode());

        result = prime * result + price;

        result = prime * result + ((vitamins == null) ? 0 : vitamins.hashCode());

        return result;

    }


    @Override

    public boolean equals(Object obj) {

        if (this == obj)

            return true;

        if (obj == null)

            return false;

        if (getClass() != obj.getClass())

            return false;

        Fruit other = (Fruit) obj;

        if (dayToLive != other.dayToLive)

            return false;

        if (deliveryDate == null) {

            if (other.deliveryDate != null)

                return false;

        } else if (!deliveryDate.equals(other.deliveryDate))

            return false;

        if (fruitType != other.fruitType)

            return false;

        if (price != other.price)

            return false;

        if (vitamins == null) {

            if (other.vitamins != null)

                return false;

        } else if (!vitamins.equals(other.vitamins))

            return false;

        return true;

    }
}

