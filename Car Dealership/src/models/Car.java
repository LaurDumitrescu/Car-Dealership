package models;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private String brand;
    private String model;
    private String yearOfFabrication;

    public Car(String brand, String model, String yearOfFabrication) {
        this.brand = brand;
        this.model = model;
        this.yearOfFabrication = yearOfFabrication;
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

    public String getYearOfFabrication() {
        return yearOfFabrication;
    }

    public void setYearOfFabrication(String yearOfFabrication) {
        this.yearOfFabrication = yearOfFabrication;
    }

    @Override
    public int compareTo(Car other) {
        int makeCompare = brand.compareTo(other.brand);
        if (makeCompare != 0) {
            return makeCompare;
        }
        int modelCompare = model.compareTo(other.model);
        if (modelCompare != 0) {
            return modelCompare;
        }
        return yearOfFabrication.compareTo(other.yearOfFabrication);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(yearOfFabrication, car.yearOfFabrication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, yearOfFabrication);
    }

}
