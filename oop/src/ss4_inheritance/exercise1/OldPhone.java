package ss4_inheritance.exercise1;

import ss6_abstractClass.Discountable;

public class OldPhone extends Phone implements Discountable {
    private int batteryStatus;
    private String description;

    public OldPhone(String id, String name, double price, int warranty, String manufacturer, String description, int batteryStatus) {
        super(id, name, price, warranty, manufacturer);
        this.description = description;
        this.batteryStatus = batteryStatus;
    }

    public int getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(int batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() +
                "', batteryStatus=" + batteryStatus +
                "', description='" + description +
                "'}";
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice();
    }

    @Override
    public void applyDiscount(double percentDiscount) {
        double discountedPrice = getPrice() * (1 - percentDiscount / 100.0);
        setPrice(discountedPrice);
    }
}
