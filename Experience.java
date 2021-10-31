public class Experience {

    private String title;
    private String startdate;
    private String endDate;
    private String description;

    public Experience(String title, String startdate, String endDate, String description) {
        this.title = title;
        this.startdate = startdate;
        this.endDate = endDate;
        this.description = description;
    }

    public String toString() {
        return title+"\nStart Date: "+startdate+"\nEnd Date: "+endDate+"\nDescription: "+description;
    }
    
    public String getTitle() {
        return this.title;
    }

    public String getStartDate() {
        return this.startdate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getDescription() {
        return this.description;
    }
}
