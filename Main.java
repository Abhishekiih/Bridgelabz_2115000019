import java.util.*;

class Task {
    int taskId, priority;
    String taskName, dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null, tail = null;
    
    void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }
    
    void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }
    
    void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position == 1 || head == null) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) tail = newTask;
    }
    
    void removeTask(int taskId) {
        if (head == null) return;
        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    
    void viewCurrentTask() {
        if (head != null) System.out.println(head.taskId + " " + head.taskName + " " + head.priority + " " + head.dueDate);
    }
    
    void moveToNextTask() {
        if (head != null) head = head.next;
    }
    
    void displayAllTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println(temp.taskId + " " + temp.taskName + " " + temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    
    void searchTaskByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority)
                System.out.println(temp.taskId + " " + temp.taskName + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
}

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTaskAtEnd(1, "Task1", 3, "2025-02-15");
        scheduler.addTaskAtEnd(2, "Task2", 2, "2025-02-16");
        scheduler.addTaskAtBeginning(3, "Task3", 1, "2025-02-17");
        scheduler.displayAllTasks();
        scheduler.removeTask(2);
        scheduler.displayAllTasks();
        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.viewCurrentTask();
        scheduler.searchTaskByPriority(1);
    }
}
