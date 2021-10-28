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
    private ArrayList<String> applicantIDS;
    private String employerID;
    private Employer employer;

    //Constructors
    public JobListing(String id, String postedDate, String expirationDate, String location, int jobPay, String employerID) {
        this.id = id;
        this.postedDate = postedDate;
        this.expirationDate = expirationDate;
        this.location = location;
        this.jobPay = jobPay;
        this.employerID = employerID;
        desiredSkills = new ArrayList<String>();
        applicants = new ArrayList<Student>();
        applicantIDS = new ArrayList<String>();
    }

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

    //Setter
    public void setEmployer(Employer aEmployer) {
        this.employer = aEmployer;
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

        if(student!=null && !(applicants.contains(student))) {
          applicants.add(student);
          applicantIDS.add(student.getUUID());
        }
    }

    public String toString() {
        String desiredSkillsString = "";
        for(int i = 0; i<desiredSkills.size(); i++) {
            desiredSkillsString+=desiredSkills.get(i);
            if(i<desiredSkills.size()-1) {
                desiredSkillsString+=", ";
            }
        }
        return "Employer: "+this.employer.getCompanyName()+"\nJob Type: "+this.jobType+"\nLocation: "+this.location+"Job Pay: "+this.jobPay+"\nExpiration Date: "+this.expirationDate+"\nPosted Date: "+this.postedDate+"Desired Skills: "+desiredSkillsString;
    }

    public ArrayList<Applicant> sortApplicants(ApplicantSortType sortType) {
        if(sortType=="nameAToZ") {
            applicants = sortAToZHelper(applicants);
        }
        else if (sortType=="nameZToA") {
            applicants = sortZToAHelper(applicants);
        }
        return applicants;
    }

    public ArrayList<String> getApplicantIDS() {
        return this.applicantIDS;
    }

    public void removeApplicant(Student applicant) {
        applicants.remove(applicant);
    }

    public String viewApplicants() {
        String applicantsString = "";
        for(int i = 0; i < applicants.size(); i++) {
            applicantsString+=applicants.get(i).getFirstName()+" "+applicants.get(i).getLastName()+"\n";
        }
        return applicantsString;
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
    private ArrayList<Applicant> sortAToZHelper(ArrayList<Applicant> applicants) {
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for(int i = 0; i<applicants.size()-1; i++) {
                if(applicants.get(i).getStudent.getLastName().compareTo(applicants.get(i+1).getStudent().getLastName())>0) {
                    Applicant temp = applicants.get(i+1);
                    applicants.set(i+1,applicants.get(i));
                    applicants.set(i,temp);
                }
            }
        }
    }
    private ArrayList<Applicant> sortZToAHelper(ArrayList<Applicant> applicants) {
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for(int i = 0; i>applicants.size()-1; i++) {
                if(applicants.get(i).getStudent().getLastName().compareTo(applicants.get(i+1).getStudent().getLastName())>0) {
                    Applicant temp = applicants.get(i+1);
                    applicants.set(i+1,applicants.get(i));
                    applicants.set(i,temp);
                }
            }
        }
    }

    public String getUUID() {
        return this.id;
    }

    public void setDesiredSkills(ArrayList<String> desiredSkills) {
        this.desiredSkills = desiredSkills;
    }

    public void setApplicantIDS(ArrayList<String> applicantIDS) {
        this.applicantIDS = applicantIDS;
    }
 }
