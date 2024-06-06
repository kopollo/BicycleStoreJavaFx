package models;


public class User {
    private String passport;
    private String name;
    private String address;
    private String password;
    private String role;
    private int id;

    public User(int id, String passport, String name, String address, String password, String role) {
        this.id = id;
        this.passport = passport;
        this.name = name;
        this.address = address;
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}