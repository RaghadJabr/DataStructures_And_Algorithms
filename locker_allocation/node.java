package locker_allocation;

public class node {
    looking data;
    node left, right;

    public node(looking data) {
        this.data = data;
        this.left = this.right = null;
    }
}
