class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head;
    private Ticket tail;

    TicketReservationSystem() {
        this.head = null;
        this.tail = null;
    }

    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
    }

    void removeTicket(int ticketId) {
        if (head == null) return;

        Ticket current = head;
        Ticket previous = null;
        do {
            if (current.ticketId == ticketId) {
                if (previous == null) {
                    if (head == tail) {
                        head = null;
                        tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    Ticket searchTicketByCustomerOrMovie(String searchTerm) {
        if (head == null) return null;

        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(searchTerm) || current.movieName.equalsIgnoreCase(searchTerm)) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }

    int totalBookedTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "John Doe", "Inception", "A1", "2025-02-11 15:00");
        system.addTicket(102, "Jane Smith", "Avatar", "B2", "2025-02-11 16:00");
        system.addTicket(103, "Alice Brown", "Titanic", "C3", "2025-02-11 17:00");

        System.out.println("All Booked Tickets:");
        system.displayTickets();

        System.out.println("\nSearching for ticket by Customer Name 'Jane Smith':");
        Ticket ticket = system.searchTicketByCustomerOrMovie("Jane Smith");
        if (ticket != null) {
            System.out.println("Found Ticket ID: " + ticket.ticketId);
        } else {
            System.out.println("No ticket found.");
        }

        System.out.println("\nTotal Booked Tickets: " + system.totalBookedTickets());

        System.out.println("\nRemoving Ticket ID 102:");
        system.removeTicket(102);

        System.out.println("\nAll Booked Tickets after removal:");
        system.displayTickets();

        System.out.println("\nTotal Booked Tickets after removal: " + system.totalBookedTickets());
    }
}
