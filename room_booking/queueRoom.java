package room_booking;

public class queueRoom {
    private static booking[] arr;
    private static int size;
    private final int DEF_CAP = 100; 

    public queueRoom() {
        arr = new booking[DEF_CAP];
        size = 0;
    }

    public static void insert(booking booking) {
        if (isFull()) {
            System.out.println("Sorry, All Rooms Are Booked");
        }
        arr[size] = booking;
        size++;
    }

    private static boolean isFull() {
        return size == arr.length;
    }

    public static booking remove() {
        if (!isEmpty()) {
            booking temp = arr[size - 1];
            size--;
            return temp;
        }
        return null;
    }

    private static boolean isEmpty() {
        return size == 0;
    }

    public static void searchRoom(int roomNumber) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getRoomNumber() == roomNumber) {
                System.out.println("Room " + roomNumber + " is already reserved by student ID: " + arr[i].getStudentId());
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is available for reservation.");
    }

    public static void printList() {
    	divide(arr, 0, size - 1);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i].toString());
        }
    }

    private static void divide(booking[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            divide(array, start, mid);
            divide(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(booking[] array, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        booking[] left = new booking[n1];
        booking[] right = new booking[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = array[start + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (left[i].getYear() >= right[j].getYear()) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}