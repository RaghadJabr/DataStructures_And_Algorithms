package lost_found_record;

public class list {
    private static Node head;
    private static int size;

    public static void addFirst(records record) {
        Node newNode = new Node(record);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public records removeFirst() {
        if (head != null) {
            records removedData = head.data; 
            head = head.next;                
            size--;
            return removedData;             
        } else {
            System.out.println("The list is empty.");
            return null;
        }
    }

    public boolean searchByDescription(String keyword) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.data.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data.toString());
            current = current.next;
        }
    }
    
    public int size() {
        return size;
    }
}