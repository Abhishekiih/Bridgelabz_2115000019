class ProcessNode {
    int pid;
    int burstTime;
    int priority;
    ProcessNode next;

    public ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class CircularLinkedList {
    ProcessNode head;

    public CircularLinkedList() {
        head = null;
    }

    public void addProcess(int pid, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(pid, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            ProcessNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newProcess;
            newProcess.next = head;
        }
    }

    public void removeProcess(int pid) {
        if (head == null) return;
        ProcessNode current = head;
        ProcessNode prev = null;
        while (true) {
            if (current.pid == pid) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    if (current.next == head) {
                        head = null;
                    } else {
                        prev = current;
                        while (prev.next != head) {
                            prev = prev.next;
                        }
                        head = current.next;
                        prev.next = head;
                    }
                }
                return;
            }
            prev = current;
            current = current.next;
            if (current == head) break;
        }
    }

    public void display() {
        if (head == null) return;
        ProcessNode current = head;
        do {
            System.out.println("PID: " + current.pid + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    public int getTotalProcesses() {
        if (head == null) return 0;
        ProcessNode current = head;
        int count = 0;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    public ProcessNode getNextProcess(ProcessNode currentProcess) {
        if (currentProcess.next == head) {
            return head;
        }
        return currentProcess.next;
    }
}

public class RoundRobinScheduling {
    public static void roundRobinScheduling(CircularLinkedList processList, int timeQuantum) {
        int totalProcesses = processList.getTotalProcesses();
        if (totalProcesses == 0) {
            System.out.println("No processes to schedule.");
            return;
        }

        ProcessNode currentProcess = processList.head;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int completedProcesses = 0;

        while (completedProcesses < totalProcesses) {
            if (currentProcess.burstTime > 0) {
                System.out.println("Executing Process " + currentProcess.pid + " for " + Math.min(currentProcess.burstTime, timeQuantum) + " units");
                if (currentProcess.burstTime <= timeQuantum) {
                    totalTurnaroundTime += currentProcess.burstTime;
                    totalWaitingTime += totalTurnaroundTime - currentProcess.burstTime;
                    currentProcess.burstTime = 0;
                    completedProcesses++;
                    processList.removeProcess(currentProcess.pid);
                } else {
                    currentProcess.burstTime -= timeQuantum;
                    totalTurnaroundTime += timeQuantum;
                }
                processList.display();
            }
            currentProcess = processList.getNextProcess(currentProcess);
        }

        double avgWaitingTime = (double) totalWaitingTime / totalProcesses;
        double avgTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;
        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    public static void main(String[] args) {
        CircularLinkedList processList = new CircularLinkedList();

        processList.addProcess(1, 10, 3);
        processList.addProcess(2, 5, 1);
        processList.addProcess(3, 8, 2);

        roundRobinScheduling(processList, 3);
    }
}
