package ss4_inheritance.exercise1;

import ss10_exception.validation.PhoneValidation;

public abstract class Phone implements Comparable<Phone> {
    private String id;
    private String name;
    private double price;
    private int warranty;
    private String manufacturer;

    public Phone() {
    }

    public Phone(String id, String name, double price, int warranty, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warranty = warranty;
        this.manufacturer = manufacturer;
    }

    public void input() {
        this.name = PhoneValidation.inputName("name");
        this.price = PhoneValidation.inputPrice("price");
        this.warranty = PhoneValidation.inputWarranty("warranty");
        this.manufacturer = PhoneValidation.inputManufacturer("manufacturer");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s", id, name, price, warranty, manufacturer);
    }

    public abstract double calculateTotalPrice();

    @Override
    public int compareTo(Phone o){
        return Double.compare(this.getPrice(), o.price);
    }
}
