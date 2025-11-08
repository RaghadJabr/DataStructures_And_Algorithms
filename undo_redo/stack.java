package undo_redo;

public class stack {
    private actions undoStack;
    private actions redoStack;
    private int maxStackSize = 100;

    public stack() {
        undoStack = new actions(maxStackSize);
        redoStack = new actions(maxStackSize);
    }

    public void doAction(String action) {
        undoStack.push(action);
        redoStack.clear(); 
        System.out.println("Action done: " + action);
    }

    public String undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return null;
        }
        String action = undoStack.pop();
        redoStack.push(action);
        System.out.println("Undo action: " + action);
        return action;
    }

    public String redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return null;
        }
        String action = redoStack.pop();
        undoStack.push(action);
        System.out.println("Redo action: " + action);
        return action;
    }

    public void printUndoRedoStatus() {
        System.out.print("Undo stack: ");
        undoStack.printStack();
        System.out.print("Redo stack: ");
        redoStack.printStack();
    }
}
