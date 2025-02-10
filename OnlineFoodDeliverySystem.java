import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

interface Discountable {
    void applyDiscount(double percentage);
    double getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity() - discount;
    }

    public void applyDiscount(double percentage) {
        discount = (getPrice() * getQuantity()) * (percentage / 100);
    }

    public double getDiscountDetails() {
        return discount;
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount;
    private static final double ADDITIONAL_CHARGE = 50;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + ADDITIONAL_CHARGE - discount;
    }

    public void applyDiscount(double percentage) {
        discount = (getPrice() * getQuantity()) * (percentage / 100);
    }

    public double getDiscountDetails() {
        return discount;
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem vegBurger = new VegItem("Veg Burger", 150, 2);
        FoodItem chickenBurger = new NonVegItem("Chicken Burger", 200, 1);

        ((Discountable) vegBurger).applyDiscount(10);
        ((Discountable) chickenBurger).applyDiscount(5);

        displayOrderDetails(vegBurger);
        displayOrderDetails(chickenBurger);
    }

    public static void displayOrderDetails(FoodItem item) {
        System.out.println(item.getItemDetails() + ", Total Price: " + item.calculateTotalPrice());
    }
}
