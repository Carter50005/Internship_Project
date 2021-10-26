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
    private ArrayList<Applicant> applicants;
    private ArrayList<String> additionalMaterial;
    private Employer employer;

    //Constructors
    public JobListing(String postedDate, String expirationDate, ArrayList<String> desiredSkills, JobType jobType, ArrayList<Applicant> applicants, String location, int jobPay, Employer employer) {
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
    public JobListing(String id, String postedDate, String expirationDate, ArrayList<String> desiredSkills, JobType jobType, ArrayList<Applicant> applicants, String location, int jobPay, Employer employer) {
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
    public ArrayList<Applicant> getApplicants() {
        return this.applicants;
    }
    public Employer getEmployer() {
        return this.employer;
    }

    public void apply(Student student) {
        if(student!=null) {
            Applicant applicant = new Applicant(student);
            applicants.add(applicant);
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

    public void uploadMaterial(String material, Student student) {
        for(int i=0; i<applicants.size();i++) {
            if(applicants.get(i).getStudent() == student) {
                applicants.get(i).addAdditionalMaterial(material);
                return;
            }
        }
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

    public void removeApplicant(Applicant applicant) {
        applicants.remove(applicant);
    }

    public String viewApplicants() {
        String applicantsString = "";
        for(int i = 0; i < applicants.size(); i++) {
            applicantsString+=applicants.get(i).getFirstName()+" "+applicants.get(i).getLastName()+"\n";
        }
    }
    public String viewApplicant(Student student) {
        for(int i=0; i<applicants.size();i++) {
            if(applicants.get(i).getStudent() == student) {
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
 }
