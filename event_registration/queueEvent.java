package event_registration;

public class queueEvent {

    private static node front;
    private static node rear;

    public queueEvent() {
        front = null;
        rear = null;
    }

    public static boolean isEmpty() {
        return front == null;
    }

    public static void enqueue(participant studentId) {
    	node new_node = new node(studentId);
        if (isEmpty()) {
            front = rear = new_node;
        } else {
            rear.next = new_node;
            rear = new_node;
        }
        printQueue();
    }

    public participant dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No student to remove.");
            return null;
        }
        participant removedStudent = front.data;
        front = front.next;
        if (front == null) rear = null;
        printQueue();
        return removedStudent;
    }
    
    public static participant peek() {
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }

    public static void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        node temp = front;
        System.out.print("Registered Students: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}