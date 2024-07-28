package ss4_inheritance.exercise1;

public class NewPhone extends Phone {
    private int quantity;

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
    public String toString() {
        return super.toString() +  "', quantity=" + quantity +
                "'}";
    }
}
