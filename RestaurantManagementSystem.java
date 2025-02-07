interface Worker {
    void performDuties();
}

class Person {
    String name;
    String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

class Chef extends Person implements Worker {
    String specialty;

    public Chef(String name, String id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is preparing " + specialty + " dishes.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialty: " + specialty);
    }
}

class Waiter extends Person implements Worker {
    String section;

    public Waiter(String name, String id, String section) {
        super(name, id);
        this.section = section;
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " is serving customers in the " + section + " section.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Section: " + section);
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("John", "C01", "Italian");
        Waiter waiter = new Waiter("Emily", "W02", "Front");

        chef.displayInfo();
        chef.performDuties();

        waiter.displayInfo();
        waiter.performDuties();
    }
}
