package Lesson12;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student extends Person {

    @JsonIgnore
    public String getSurname() {

        return super.getSurname();

    }


    public Student() {

    }


    public Student(String name, String surname, int yearOfBorn) {

        super(name, surname, yearOfBorn);

    }


}
