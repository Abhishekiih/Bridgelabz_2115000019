class CircularBuffer {
    private int[] buffer;
    private int size, front, rear, count;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(int value) {
        rear = (rear + 1) % size;
        buffer[rear] = value;
        
        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size; // Overwrite oldest element
        }
    }

    public int dequeue() {
        if (count == 0) throw new RuntimeException("Buffer is empty!");

        int value = buffer[front];
        front = (front + 1) % size;
        count--;

        return value;
    }

    public void display() {
        System.out.print("Buffer: ");
        for (int i = 0, index = front; i < count; i++) {
            System.out.print(buffer[index] + " ");
            index = (index + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        cb.display(); 

        cb.enqueue(4); 
        cb.display(); 

        cb.dequeue();
        cb.display(); 
    }
}
