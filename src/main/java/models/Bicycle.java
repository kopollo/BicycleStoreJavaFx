package models;

public class Bicycle {
    private int id;
    private int bicycleModelId;

    public Bicycle(int id, int bicycleModelId) {
        this.id = id;
        this.bicycleModelId = bicycleModelId;
    }

    public Bicycle(int bicycleModelId) {
        this(0, bicycleModelId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBicycleModelId() {
        return bicycleModelId;
    }

    public void setBicycleModelId(int bicycleModelId) {
        this.bicycleModelId = bicycleModelId;
    }
}