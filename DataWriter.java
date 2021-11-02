import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants { 

    private static ArrayList<User> users;
    private static ArrayList<Student> students;
    private static ArrayList<Employer> employers;
    private static ArrayList<Admin> admins;

    public static void saveUsers(ArrayList<User> users) {
        
        students = UserList.getInstance().getStudents();
        employers = UserList.getInstance().getEmployers();
        admins = UserList.getInstance().getAdmins();
        JSONArray jsonUsers  = new JSONArray();

        for(User user : users) {
            if(user.getType().equalsIgnoreCase("s")) {
                jsonUsers.add(getStudentJSON(user));
            }
            else if(user.getType().equalsIgnoreCase("e")) {
                jsonUsers.add(getEmployerJSON(user));
            }
            else if(user.getType().equalsIgnoreCase("a")) {
                jsonUsers.add(getAdminJSON(user));
            }

            try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
                file.write(jsonUsers.toJSONString());
                file.flush();
     
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveJobListing(ArrayList<JobListing> listings) {
        JSONArray jobListingsJSON = new JSONArray();

        for(JobListing listing : listings) {
            jobListingsJSON.add(getListingJSON(listing));
        }

        try (FileWriter file = new FileWriter(LISTING_FILE_NAME)) {
 
            file.write(jobListingsJSON.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getListingJSON(JobListing listing) {
        JSONObject listingJSON = new JSONObject();
        listingJSON.put(JOB_LISTING_ID, listing.getId().toString());
        listingJSON.put(JOB_LISTING_TITLE, listing.getTitle().toString());
        listingJSON.put(JOB_POSTED_DATE, listing.getPostedDate().toString());
        listingJSON.put(JOB_EXPIRATION_DATE, listing.getExpirationDate().toString());
        listingJSON.put(JOB_DESIRED_SKILLS, getDesiredSkillsJSON(listing));
        listingJSON.put(JOB_LOCATION, listing.getLocation());
        listingJSON.put(JOB_PAY, String.valueOf(listing.getJobPay()));
        listingJSON.put(JOB_APPLICANT_IDS, getApplicantIDSJSON(listing));
        listingJSON.put(JOB_EMPLOYER_ID, listing.getEmployerID().toString());
        return listingJSON;
    }

    private static JSONArray getApplicantIDSJSON(JobListing listing) {
        JSONArray applicantIDSJSON = new JSONArray();
        for(String id : listing.getApplicantIDS()) {
            JSONObject applicantIDJSON = new JSONObject();
            applicantIDJSON.put(APPLICANT_ID, id);
            applicantIDSJSON.add(applicantIDJSON);
        }
        return applicantIDSJSON;
    }

    private static JSONArray getDesiredSkillsJSON(JobListing listing) {
        JSONArray skillsJSON = new JSONArray();
        for(String skill : listing.getDesiredSkills()) {
            JSONObject skillJSON = new JSONObject();
            skillJSON.put(SKILLS_SKILL, skill.toString());
            skillsJSON.add(skillJSON);
        }
        return skillsJSON;
    }

    private static Student getStudent(User user) {
        for(int i=0;i<students.size();i++) {
            if(students.get(i).getUUID().equalsIgnoreCase(user.getUUID())) {
                return students.get(i);
            }
        }
        return null;
    }

    private static Employer getEmployer(User user) {
        for(int i=0;i<employers.size();i++) {
            if(employers.get(i).getUUID().equalsIgnoreCase(user.getUUID())) {
                return employers.get(i);
            }
        }
        return null;
    }

    private static Admin getAdmin(User user) {
        for(int i=0;i<admins.size();i++) {
            if(admins.get(i).getUUID().equalsIgnoreCase(user.getUUID())) {
                return admins.get(i);
            }
        }
        return null;
    }

    public static JSONObject getStudentJSON(User user) {
        if(getStudent(user) == null) {
            return null;
        }   
        Student student = getStudent(user);
        JSONObject studentJSON = new JSONObject();
        studentJSON.put(USER_USERNAME, student.getUsername().toString());
        studentJSON.put(USER_PASSWORD, student.getPassword().toString());
        studentJSON.put(USER_TYPE, student.getType().toString());
        studentJSON.put(USER_UUID, student.getUUID().toString());
        studentJSON.put(STUDENT_FIRST_NAME, student.getFirstName().toString());
        studentJSON.put(STUDENT_LAST_NAME, student.getLastName().toString());
        studentJSON.put(STUDENT_EMAIL, student.getEmail().toString());
        studentJSON.put(STUDENT_PHONE_NUMBER, student.getPhoneNumber().toString());
        studentJSON.put(STUDENT_RESUMES, getStudentResumesJSON(student));
        studentJSON.put(USER_REVIEWS, getStudentReviews(student));
        return studentJSON;
    }

    private static JSONArray getStudentResumesJSON(Student student) {
        JSONArray studentResumesJSON = new JSONArray();
        for(int i=0;i<student.getResumes().size();i++) {
            JSONObject resumeJSON = new JSONObject();
            Resume resume = student.getResumes().get(i);
            resumeJSON.put(RESUME_EDUCATIONS, getResumeEducations(resume));
            resumeJSON.put(RESUME_SKILLS, getResumeSkills(resume));
            resumeJSON.put(RESUME_WORK, getResumeExperiences(resume.getWorkExperiences()));
            resumeJSON.put(RESUME_EXTRACURRICULARS, getResumeExperiences(resume.getExtraCurriculars()));
            studentResumesJSON.add(resumeJSON);
        }
        return studentResumesJSON;
    }

    public static JSONArray getResumeEducations(Resume resume) {
        JSONArray educationsJSON = new JSONArray();
        for(int i=0;i<resume.getEducations().size();i++) {
            Education education = resume.getEducations().get(i);
            JSONObject educationJSON = new JSONObject();
            educationJSON.put(EDUCATIONS_SCHOOL, education.getSchool().toString());
            educationJSON.put(EDUCATIONS_YEAR, String.valueOf(education.getClassYear()));
            educationJSON.put(EDUCATIONS_MAJOR, education.getMajor().toString());
            educationJSON.put(EDUCATIONS_MINOR, education.getMinor().toString());
            educationJSON.put(EDUCATIONS_GPA, String.valueOf(education.getGpa()));
            educationsJSON.add(educationJSON);
        }
        return educationsJSON;
    }

    private static JSONArray getResumeSkills(Resume resume) {
        JSONArray skillsJSON = new JSONArray();
        for(int i=0;i<resume.getSkills().size();i++) {
            JSONObject skillJSON = new JSONObject();
            skillJSON.put(SKILLS_SKILL, resume.getSkills().get(i).toString());
            skillsJSON.add(skillJSON);
        }
        return skillsJSON;
    }

    public static JSONArray getResumeExperiences(ArrayList<Experience> experiences) {
        JSONArray experiencesJSON = new JSONArray();
        for(int i=0;i<experiences.size();i++) {
            JSONObject experienceJSON = new JSONObject();
            Experience experience = experiences.get(i);
            experienceJSON.put(EXPERIENCE_TITLE, experience.getTitle().toString());
            experienceJSON.put(EXPERIENCE_START, experience.getStartDate().toString());
            experienceJSON.put(EXPERIENCE_END, experience.getEndDate().toString());
            experienceJSON.put(EXPERIENCE_DESCRIPTION, experience.getDescription().toString());
            experiencesJSON.add(experienceJSON);
        }
        return experiencesJSON;
    }

    public static JSONArray getStudentReviews(Student student) {
        JSONArray reviewsJSON = new JSONArray();
        for(int i=0;i<student.getReviews().size();i++) {
            JSONObject reviewJSON = new JSONObject();
            Review review = student.getReviews().get(i);
            reviewJSON.put(REVIEW_RATING, String.valueOf(review.getRating()));
            reviewJSON.put(REVIEW_REVIEW, review.getReview());
            reviewJSON.put(REVIEW_REVIEWEE, review.getRevieweeID());
            reviewJSON.put(REVIEW_REVIEWER, review.getReviewerID());
            reviewsJSON.add(reviewJSON);
        }
        return reviewsJSON;
    }

    private static JSONObject getEmployerJSON(User user) {
        JSONObject employerJSON = new JSONObject();
        Employer employer = getEmployer(user);
        employerJSON.put(USER_USERNAME, employer.getUsername().toString());
        employerJSON.put(USER_PASSWORD, employer.getPassword().toString());
        employerJSON.put(USER_TYPE, employer.getType().toString());
        employerJSON.put(USER_UUID, employer.getUUID().toString());
        employerJSON.put(EMPLOYER_NAME, employer.getCompanyName().toString());
        employerJSON.put(EMPLOYER_DESCRIPTION, employer.getCompanyDescription().toString());
        employerJSON.put(EMPLOYER_LOCATION, employer.getCompanyLocation().toString());
        employerJSON.put(USER_REVIEWS, getEmployerReviews(employer));
        return employerJSON;
    }
    
    private static JSONArray getEmployerReviews(Employer employer) {
        JSONArray reviewsJSON = new JSONArray();
        for(int i=0;i<employer.getReviews().size();i++) {
            JSONObject reviewJSON = new JSONObject();
            Review review = employer.getReviews().get(i);
            reviewJSON.put(REVIEW_RATING, String.valueOf(review.getRating()));
            reviewJSON.put(REVIEW_REVIEW, review.getReview());
            reviewJSON.put(REVIEW_REVIEWEE, review.getRevieweeID());
            reviewJSON.put(REVIEW_REVIEWER, review.getReviewerID());
            reviewsJSON.add(reviewJSON);
        }
        return reviewsJSON;
    }

    private static JSONObject getAdminJSON(User user) {
        JSONObject adminJSON = new JSONObject();
        Admin admin = getAdmin(user);
        adminJSON.put(USER_USERNAME, admin.getUsername().toString());
        adminJSON.put(USER_PASSWORD, admin.getPassword().toString());
        adminJSON.put(USER_TYPE, admin.getType().toString());
        adminJSON.put(USER_UUID, admin.getUUID().toString());
        return adminJSON;
    }
}
