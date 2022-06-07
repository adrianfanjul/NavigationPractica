package com.tokioschool.navigationpractica.domain;

public class CarItem {

    private final float price;
    private final String carType;
    private final ResourcesCar resourcesCar;

    public CarItem(float price, String cartype, ResourcesCar resourcesCar) {
        this.price = price;
        this.carType = cartype;
        this.resourcesCar = resourcesCar;
    }

    public float getPrice() {
        return price;
    }

    public String getCarType() {
        return carType;
    }

    public ResourcesCar getResourcesCar() {
        return resourcesCar;
    }
}
