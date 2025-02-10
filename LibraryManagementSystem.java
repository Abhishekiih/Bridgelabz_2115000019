import java.util.*;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public abstract int getLoanDuration();

    public String getItemDetails() {
        return "Item ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem() {
        System.out.println("Book reserved: " + getTitle());
    }

    public boolean checkAvailability() {
        return true;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 5;
    }

    public void reserveItem() {
        System.out.println("DVD reserved: " + getTitle());
    }

    public boolean checkAvailability() {
        return false;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem book = new Book("B001", "Java Programming", "James Gosling");
        LibraryItem magazine = new Magazine("M001", "Tech Today", "Editorial Team");
        LibraryItem dvd = new DVD("D001", "Inception", "Christopher Nolan");

        displayItemDetails(book);
        displayItemDetails(magazine);
        displayItemDetails(dvd);
    }

    public static void displayItemDetails(LibraryItem item) {
        System.out.println(item.getItemDetails() + ", Loan Duration: " + item.getLoanDuration() + " days");
    }
}
