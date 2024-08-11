package ss4_inheritance.exercise1;

import ss10_exception.validation.PhoneValidation;

public class NewPhone extends Phone {
    private int quantity;

    public NewPhone() {
        super();
    }

    public NewPhone(String id, String name, double price, int warranty, String manufacturer, int quantity) {
        super(id, name, price, warranty, manufacturer);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void input(){
        super.input();
        this.quantity = PhoneValidation.inputQuantity("quantity");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(",,, %s" , quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * quantity;
    }
}
