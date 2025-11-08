package undo_redo;

public class actions {
    private final int MAXSIZE;
    private String[] stackArray;
    private int top;

    public actions(int size) {
        MAXSIZE = size;
        stackArray = new String[MAXSIZE];
        top = -1;
    }

    public void push(String value) {
        if (top < MAXSIZE - 1) {
            stackArray[++top] = value;
        } else {
            System.out.println("Stack overflow! Cannot push: " + value);
        }
    }

    public String pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty! Cannot pop.");
            return null;
        }
    }

    public String peek() {
        return (!isEmpty()) ? stackArray[top] : null;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void clear() {
        top = -1;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + (i > 0 ? " -> " : "\n"));
        }
    }
}

 