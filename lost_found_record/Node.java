package lost_found_record;

public class Node {
    records data;
    Node next;

    public Node(records records) {
        this.data = records;
        this.next = null;
    }

}
