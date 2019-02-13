package Lesson12;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "MateGroup")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"teacher", "assistant", "students", "room", "humanResources", "id"})
public class MateGroup implements Serializable {

    @XmlElement(type = Teacher.class)
    private Person teacher;
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
    @JsonSubTypes({@JsonSubTypes.Type(value = Teacher.class, name = "teacher"),
            @JsonSubTypes.Type(value = Student.class, name = "student")})

    private List<Person> students;
    @XmlElement(required = true, nillable = false)
    private Room room;
    @XmlElementWrapper(name = "hrs")
    @XmlElement(name = "humanResource")
    private Set<HumanResource> humanResources;
    private int id;

    @XmlElement
    private Person assistant;

    public MateGroup(Teacher teacher, Assistant assistant, List<Person> students, Room room, Set<HumanResource> humanResources) {
        this.teacher = teacher;
        this.assistant = assistant;
        this.students = students;
        this.room = room;
        this.humanResources = humanResources;
    }

    public MateGroup() {
    }

    public Person getTeacher() {
        return teacher;
    }


    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<HumanResource> getHumanResources() {
        return humanResources;
    }

    public void setHumanResources(Set<HumanResource> humanResources) {
        this.humanResources = humanResources;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    @Override
    public String toString() {
        return "MateGroup{" +
                "teacher=" + teacher +
                ", students=" + students +
                ", room=" + room +
                ", humanResources=" + humanResources +
                ", id=" + id +
                ", assistant=" + assistant +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static MateGroup mateGroupExampleCreator() {
        MateGroup mateGroup = new MateGroup();
        mateGroup.setId(18122018);

        Teacher teacher = new Teacher("Serhii", "Pasko", 1988, 666);
        mateGroup.setTeacher(teacher);

        Assistant assistant = new Assistant("Fidel", "Kastro", 1999, "0007");
        mateGroup.setAssistant(assistant);

        Room room = new Room("Kiyv", "Tarasivska", 16, 28);
        mateGroup.setRoom(room);

        Set<HumanResource> humanResources = new HashSet<>();
        humanResources.add(new HumanResource("Karmen", "Sandiego", 1990, 2015));
        humanResources.add(new HumanResource("Efiria", "MyFantasyFinished", 1989, 2016));
        mateGroup.setHumanResources(humanResources);

        List<Person> students = new ArrayList<>();
        students.add(new Student("Iza", "Rabinovish", 1997));
        students.add(new Student("Abram", "Kolom", 1998));
        students.add(new Teacher("Moisha", "Stefan", 1990, 666));
        mateGroup.setStudents(students);

        return mateGroup;
    }

}