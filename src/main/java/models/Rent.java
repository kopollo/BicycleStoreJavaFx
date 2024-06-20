package models;

import java.sql.Date;

public class Rent {
    private int id;
    private int clientId;
    private int bicycleId;
    private int shopId;
    private Date takeDate;
    private Date returnDate;

    public Rent(int id, int clientId, int bicycleId, int shopId, Date takeDate, Date returnDate) {
        this.id = id;
        this.clientId = clientId;
        this.bicycleId = bicycleId;
        this.shopId = shopId;
        this.takeDate = takeDate;
        this.returnDate = returnDate;
    }

    public Rent(int clientId, int bicycleId, int shopId, Date takeDate, Date returnDate) {
        this(0, clientId, bicycleId, shopId, takeDate, returnDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(int bicycleId) {
        this.bicycleId = bicycleId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public Date getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(Date takeDate) {
        this.takeDate = takeDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}