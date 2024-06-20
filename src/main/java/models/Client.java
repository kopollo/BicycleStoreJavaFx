package models;

public class Client {
    private int id;
    private String passport;
    private String name;
    private String address;

    public Client(int id, String passport, String name, String address) {
        this.id = id;
        this.passport = passport;
        this.name = name;
        this.address = address;
    }

    public Client(String passport, String name, String address) {
        this(0, passport, name, address);
    }

    public int getId() {
        return id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
