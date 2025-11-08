package event_registration;

public class participant {
    private String name;
    private int id;

    public participant(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getStudentId() {
        return name;
    }

    public int getName() {
        return id;
    }
}