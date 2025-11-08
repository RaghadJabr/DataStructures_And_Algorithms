package locker_allocation;

public class looking {
    int StudentID;
    int LockerID;

    public looking(int StudentID, int lockerNumber) {
        this.StudentID = StudentID;
        this.LockerID = lockerNumber;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        this.StudentID = studentID;
    }

    public int getLockerID() {
        return LockerID;
    }

    public void setLockerID(int lockerID) {
        this.LockerID = lockerID;
    }

    @Override
    public String toString() {
        return "Student ID: " + StudentID + ", Locker ID: " + LockerID;
    }
}
