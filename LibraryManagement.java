import java.util.*;

class Book {
    String title, author, genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head = null;

    void addBookAtBeginning(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (head != null) {
            newBook.next = head;
            head.prev = newBook;
        }
        head = newBook;
    }

    void addBookAtEnd(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = newBook;
            return;
        }
        Book temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newBook;
        newBook.prev = temp;
    }

    void removeBook(int bookId) {
        if (head == null) return;
        if (head.bookId == bookId) {
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }
        Book temp = head;
        while (temp != null && temp.bookId != bookId) temp = temp.next;
        if (temp != null) {
            if (temp.next != null) temp.next.prev = temp.prev;
            if (temp.prev != null) temp.prev.next = temp.next;
        }
    }

    void searchBookByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
                return;
            }
            temp = temp.next;
        }
    }

    void searchBookByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            }
            temp = temp.next;
        }
    }

    void updateAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                return;
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    void displayReverse() {
        if (head == null) return;
        Book temp = head;
        while (temp.next != null) temp = temp.next;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBookAtEnd(1, "1984", "George Orwell", "Dystopian", true);
        library.addBookAtEnd(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", true);
        library.addBookAtBeginning(3, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", false);

        library.searchBookByTitle("1984");
        library.updateAvailability(1, false);
        System.out.println("Total Books in Library: " + library.countBooks());
        System.out.println("Books in Forward Order:");
        library.displayForward();
        System.out.println("Books in Reverse Order:");
        library.displayReverse();
    }
}