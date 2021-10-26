import java.util.ArrayList;
import java.util.Random;
/**
 * Class that creates objects for job listings
 */

 public class JobListing {

    private String id;
    private String postedDate;
    private String expirationDate;
    private ArrayList<String> desiredSkills;
    private JobType jobType;
    private String location;
    private int jobPay;
    private ArrayList<String> applicantIDS;
    private String employerID; 

    public JobListing(String postedDate, String expirationDate, ArrayList<String> desiredSkills, JobType jobType, ArrayList<String> applicantIDS, String location, int jobPay, String employerID) {
        this.id = createID();
        this.postedDate = postedDate;
        this.expirationDate = expirationDate;
        this.desiredSkills = desiredSkills;
        this.jobType = jobType;
        this.location = location;
        this.jobPay = jobPay;
        this.applicantIDS = applicantIDS;
        this.employerID = employerID;
    }

    public JobListing(String id, String postedDate, String expirationDate, ArrayList<String> desiredSkills, JobType jobType, ArrayList<String> applicantIDS, String location, int jobPay, String employerID) {
        this.id = id;
        this.postedDate = postedDate;
        this.expirationDate = expirationDate;
        this.desiredSkills = desiredSkills;
        this.jobType = jobType;
        this.location = location;
        this.jobPay = jobPay;
        this.applicantIDS = applicantIDS;
        this.employerID = employerID;
    }

    public void apply(Student student) {
        applicantIDS.add(student.getUUID());
    }

    public String toString() {
        return "";
    }

    public void uploadMaterial(String material, Student student) {

    }

    public void sortApplicants(ApplicantSortType sortType) {
        
    }

    public ArrayList<String> getApplicants() {
        return this.applicantIDS;
    }

    public String viewApplicant(Student student) {
        for(int i=0; i<applicantIDS.size();i++) {
            if(applicantIDS.get(i) == student.getUUID()) {
                return student.toString();
            }
        }
        return "Not an applicant";
    }

    public String createID() {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return String.valueOf(alphabet.charAt(random.nextInt(alphabet.length())))+uUIDNumbers();
    }

    private String uUIDNumbers() {
        Random random = new Random();
        String ret = "";
        for(int i=0;i<6;i++) {
            ret += random.nextInt(9);
        }
        return ret;
    }

    public String getUUID() {
        return this.id;
    }
 }
