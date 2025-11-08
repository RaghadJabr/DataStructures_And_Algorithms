package lost_found_record;

public class records {
	    String description;
	    String date;
	    String location;

	    public records(String description, String date, String location) {
	        this.description = description;
	        this.date = date;
	        this.location = location;
	    }
	    
	    public String getDescription() {
	        return description;
	    }

	    public String getDate() {
	        return date;
	    }

	    public String getLocation() {
	        return location;
	    }


	    public String toString() {
	        return "Description: " + description + ", Date: " + date + ", Location: " + location;
	    }
}