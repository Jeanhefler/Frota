package entities;

import java.util.Objects;

public abstract class Vehicle {
    private String plate;
    private String brand;
    private String model;
    private int year;
    public String getPlate() {
        return plate;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle equaVehicle = (Vehicle) o;
        return getPlate() == this.getPlate() && Objects.equals(getPlate(),equaVehicle.getPlate());
    }
}