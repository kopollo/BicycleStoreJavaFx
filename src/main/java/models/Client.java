package models;

public class Client {
    private int id;
    private String passport;
    private String name;
    private String address;
    private String password;

    public Client(int id, String passport, String name, String address, String password) {
        this.id = id;
        this.passport = passport;
        this.name = name;
        this.address = address;
        this.password = password;
    }

    public Client(String passport, String name, String address, String password) {
        this(0, passport, name, address, password);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
