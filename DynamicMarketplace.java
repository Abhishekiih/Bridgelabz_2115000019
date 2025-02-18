import java.util.ArrayList;
import java.util.List;

abstract class ProductCategory {
    private String categoryName;

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() { return categoryName; }
}

class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}

class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public T getCategory() { return category; }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return name + " (" + category.getCategoryName() + ") - $" + price;
    }
}

class Marketplace {
    private List<Product<? extends ProductCategory>> catalog = new ArrayList<>();

    public void addProduct(Product<? extends ProductCategory> product) {
        catalog.add(product);
    }

    public void displayCatalog() {
        System.out.println("\nProduct Catalog:");
        for (Product<? extends ProductCategory> product : catalog) {
            System.out.println(product);
        }
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        double newPrice = product.getPrice() - discount;
        product.setPrice(newPrice);
        System.out.println("Discount applied! New price of " + product.getName() + " is $" + newPrice);
    }
}

public class DynamicMarketplace {
    public static void main(String[] args) {
        BookCategory bookCategory = new BookCategory();
        ClothingCategory clothingCategory = new ClothingCategory();
        GadgetCategory gadgetCategory = new GadgetCategory();

        Product<BookCategory> book = new Product<>("The Java Handbook", 49.99, bookCategory);
        Product<ClothingCategory> tShirt = new Product<>("Cool T-Shirt", 19.99, clothingCategory);
        Product<GadgetCategory> smartphone = new Product<>("Smartphone X", 999.99, gadgetCategory);

        Marketplace marketplace = new Marketplace();
        marketplace.addProduct(book);
        marketplace.addProduct(tShirt);
        marketplace.addProduct(smartphone);

        marketplace.displayCatalog();

        Marketplace.applyDiscount(book, 10);
        Marketplace.applyDiscount(tShirt, 20);
        Marketplace.applyDiscount(smartphone, 5);

        marketplace.displayCatalog();
    }
}
