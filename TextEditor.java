class Node {
    String data;
    Node prev;
    Node next;

    Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private Node current;
    private Node head;
    private Node tail;
    private int size;
    private final int historyLimit;

    TextEditor(int historyLimit) {
        this.historyLimit = historyLimit;
        this.size = 0;
        this.current = null;
        this.head = null;
        this.tail = null;
    }

    void addState(String text) {
        Node newNode = new Node(text);

        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = newNode;
        }

        size++;

        if (size > historyLimit) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    String undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            return current.data;
        }
        return null;
    }

    String redo() {
        if (current != null && current.next != null) {
            current = current.next;
            return current.data;
        }
        return null;
    }

    String displayCurrentState() {
        return current != null ? current.data : "No content";
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor(5);

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! How");
        editor.addState("Hello World! How are");

        System.out.println("Current State: " + editor.displayCurrentState());

        System.out.println("Undo: " + editor.undo());
        System.out.println("Undo: " + editor.undo());
        System.out.println("Redo: " + editor.redo());
        System.out.println("Redo: " + editor.redo());
    }
}
