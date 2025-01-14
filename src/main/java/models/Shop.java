package models;

public class Shop {
    private int id;
    private String name;
    private String address;

    public Shop(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Shop(String name, String address) {
        this(0, name, address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
