import java.util.ArrayList;
/**
 * Class that creates objects for job listings
 */

 public class JobListing {

    private String postedDate;
    private String expirationDate;
    private ArrayList<String> desiredSkills;
    private JobType jobType;
    private String location;
    private int jobPay;
    private ArrayList<Student> applicants;
    private Employer employer; 

    public JobListing(String postedDate, String expirationDate, ArrayList<String> desiredSkills, JobType jobType, ArrayList<Student> applicants, String location, int jobPay, Employer employer) {
        this.postedDate = postedDate;
        this.expirationDate = expirationDate;
        this.desiredSkills = desiredSkills;
        this.jobType = jobType;
        this.location = location;
        this.jobPay = jobPay;
        this.applicants = applicants;
        this.employer = employer;
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

    public ArrayList<Student> getApplicants() {
        return this.applicants;
    }

    public String viewApplicant(Student student) {
        for(int i=0; i<applicants.size();i++) {
            if(applicants.get(i) == student) {
                return student.toString();
            }
        }
        return "Not an applicant";
    }
 }
