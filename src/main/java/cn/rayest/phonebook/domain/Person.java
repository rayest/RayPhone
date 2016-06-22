package cn.rayest.phonebook.domain;

/**
 * Created by xubt on 4/23/16.
 */
public class Person {

    private int id;
    private String name;
    private String phoneNumber;

    public Person() {
    }

    public Person(String name, String phoneNumber) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Person(int id, String name, String phoneNumber) {
        super();
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}


