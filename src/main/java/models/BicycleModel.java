package models;

public class BicycleModel {
    private int id;
    private String name;
    private int numOfGears;
    private String type;

    public BicycleModel(int id, String name, int numOfGears, String type) {
        this.id = id;
        this.name = name;
        this.numOfGears = numOfGears;
        this.type = type;
    }

    public BicycleModel(String name, int numOfGears, String type) {
        this(0, name, numOfGears, type);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfGears() {
        return numOfGears;
    }

    public void setNumOfGears(int numOfGears) {
        this.numOfGears = numOfGears;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
