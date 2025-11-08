package locker_allocation;

public class location {
    node root;

    public node insert(node root, looking data) {
        // Check locker availability before inserting
        if (root == null) return new node(data);
        if (data.getLockerID() < root.data.getLockerID()) {
            root.left = insert(root.left, data);
			System.out.println("Locker assigned successfully.");

        } else if (data.getLockerID() > root.data.getLockerID()) {
            root.right = insert(root.right, data);
			System.out.println("Locker assigned successfully.");
        } else {
            System.out.println("Locker ID " + data.getLockerID() + " already exists.");
        }

        return root;
    }


    public void insert(looking data) {
        root = insert(root, data);
    }

    public looking search(node root, int studentID) {
        if (root == null) return null;
        if (studentID == root.data.getStudentID()) return root.data;
        if (studentID < root.data.getStudentID()) return search(root.left, studentID);
        else return search(root.right, studentID);
    }

    public looking search(int studentID) {
        return search(root, studentID);
    }

    // In-order Traversal
    public void inOrderTraversal(node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    public void printAll() {
        inOrderTraversal(root);
    }

    // Remove by StudentID
    public node remove(node root, int studentID) {
        if (root == null) return null;

        if (studentID < root.data.getStudentID()) {
            root.left = remove(root.left, studentID);
        } else if (studentID > root.data.getStudentID()) {
            root.right = remove(root.right, studentID);
        } else {
            // Node found
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            node minNode = getMin(root.right);
            root.data = minNode.data;
            root.right = remove(root.right, minNode.data.getStudentID());
        }
        return root;
    }

    private node getMin(node root) {
        while (root.left != null) root = root.left;
        return root;
    } 

	public void remove(int studentID) {
        root = remove(root, studentID);
    }
}