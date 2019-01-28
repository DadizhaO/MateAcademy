package Lesson12;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlTransient;

@JsonIgnoreProperties("email")
public class Assistant extends Person {

    private static String email = "@gmail";

    @JsonProperty("Phone Number")
    private String phone;

    Assistant(String name, String surname, int yearOfBorn, String phone) {
        super(name, surname, yearOfBorn);
        this.phone = phone;
    }

    public Assistant() {
        super();
    }

    @XmlTransient
    @JsonIgnore
    @Override
    public String getSurname() {
        return super.getSurname();
    }


    @Override
    public String getName() {

        return super.getName();

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
