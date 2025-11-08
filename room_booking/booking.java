package room_booking;

public class booking {
	private int studentId;
    private int roomNumber;
    private int year;


    public booking(int studentId, int roomNumber, int year) {
        this.studentId = studentId;
        this.roomNumber = roomNumber;
        this.year = year;
    }
    public int getStudentId() {
        return studentId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    
    public int getYear() {
        return year;
    }
    
    public String toString() {
        return "ID: " + studentId + ", Study Room Number: " + roomNumber + ", University Year: " + year;
    }
}
