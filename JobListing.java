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
    private ArrayList<Student> applicants;
    private Employer employer; 

    //Constructors
    public JobListing(String postedDate, String expirationDate, ArrayList<String> desiredSkills, JobType jobType, ArrayList<Student> applicants, String location, int jobPay, Employer employer) {
        this.id = createID();
        this.postedDate = postedDate;
        this.expirationDate = expirationDate;
        this.desiredSkills = desiredSkills;
        this.jobType = jobType;
        this.location = location;
        this.jobPay = jobPay;
        this.applicants = applicants;
        this.employer = employer;
    }
    public JobListing(String id, String postedDate, String expirationDate, ArrayList<String> desiredSkills, JobType jobType, ArrayList<Student> applicants, String location, int jobPay, Employer employer) {
        this.id = id;
        this.postedDate = postedDate;
        this.expirationDate = expirationDate;
        this.desiredSkills = desiredSkills;
        this.jobType = jobType;
        this.location = location;
        this.jobPay = jobPay;
        this.applicants = applicants;
        this.employer = employer;
    }

    //Getters
    public String getId() {
        return this.id;
    }
    public String getPostedDate() {
        return this.getPostedDate();
    }
    public String getExpirationDate() {
        return this.expirationDate;
    }
    public ArrayList<String> getDesiredSkills() {
        return this.desiredSkills;
    }
    public JobType getJobType() {
        return this.jobType;
    }
    public String getLocation() {
        return this.location;
    }
    public int getJobPay() {
        return this.jobPay;
    }
    public ArrayList<Student> getApplicants() {
        return this.applicants;
    }
    public Employer getEmployer() {
        return this.employer;
    }

    public void apply(Student student) {
        applicants.add(student);
    }

    public String toString() {
        return "";
    }

    public void uploadMaterial(String material, Student student) {

    }

    public void sortApplicants(ApplicantSortType sortType) {
        
    }

    public String viewApplicant(Student student) {
        for(int i=0; i<applicants.size();i++) {
            if(applicants.get(i) == student) {
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
 }
