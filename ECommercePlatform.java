import java.util.*;

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "18% VAT";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    public double calculateTax() {
        return getPrice() * 0.12;
    }

    public String getTaxDetails() {
        return "12% Sales Tax";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Product prod1 = new Electronics(101, "Laptop", 70000);
        Product prod2 = new Clothing(102, "Jacket", 3000);
        Product prod3 = new Groceries(103, "Rice", 500);

        displayFinalPrice(prod1);
        displayFinalPrice(prod2);
        displayFinalPrice(prod3);
    }

    public static void displayFinalPrice(Product product) {
        double discount = product.calculateDiscount();
        double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
        double finalPrice = product.getPrice() + tax - discount;
        System.out.println("Product: " + product.getName() + ", Final Price: " + finalPrice);
    }
}
