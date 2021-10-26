import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{
    
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)parser.parse(reader);
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				String username = (String)personJSON.get(USER_USERNAME);
				String password = (String)personJSON.get(USER_PASSWORD);
				char userType = (char)personJSON.get(USER_TYPE);
				String uUID = (String)personJSON.get(USER_UUID);
				if(userType == 's') {
					Student student = loadStudent(username, password, uUID, personJSON);
					student.setResumes(loadResumes(personJSON, student));
					student.setReviews(loadReviews(personJSON));
					ArrayList<String> wishlist = new ArrayList<String>();
					JSONArray wishlistArray = (JSONArray)personJSON.get(STUDENT_WISHLIST);
					for(int k=0;k<wishlistArray.size();k++) {
						JSONObject listing = (JSONObject)wishlistArray.get(k);
						String wishlistID = (String)listing.get(WISHLIST_ID);
						wishlist.add(wishlistID);
					}
					student.setWishlist(wishlist);
					users.add(student);
				}
				else if(userType == 'e') {
					users.add(loadEmployer(username, password, uUID, personJSON));
				}
				else if(userType == 'a') {
					users.add(new Admin(username, password, uUID));
				}
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

	public static ArrayList<JobListing> getJobListings() {
		ArrayList<JobListing> ret = new ArrayList<JobListing>();
		
		return ret;
	}

	/**
	 * retuens student 
	 * @param username 
	 * @param password
	 * @param uUID
	 * @param personJSON array of users
	 * @return instance of student 
	 */
	private static Student loadStudent(String username, String password, String uUID, JSONObject personJSON) {
		String firstName = (String)personJSON.get(STUDENT_FIRST_NAME);
		String lastName = (String)personJSON.get(STUDENT_LAST_NAME);
		String email = (String)personJSON.get(STUDENT_EMAIL);
		loadResumes(personJSON, new Student(username, password, uUID, firstName, lastName, email));
		return new Student(username, password, uUID, firstName, lastName, email);
	} 

	private static Employer loadEmployer(String username, String password, String uUID, JSONObject personJSON) {
		String name = (String)personJSON.get(EMPLOYER_NAME);
		String description = (String)personJSON.get(EMPLOYER_DESCRIPTION);
		String location = (String)personJSON.get(EMPLOYER_LOCATION);
		int rating = (int)personJSON.get(EMPLOYER_RATING);
		return new Employer(username, password, name, description, location, rating);
	} 

	/**
	 * Loads resumes
	 * @param personJSON person whos resumes are being loaded
	 * @param student student who resumes should be added to
	 * @return ArrayList of type resume
	 */
	private static ArrayList<Resume> loadResumes(JSONObject personJSON, Student student) {
		ArrayList<Resume> ret = new ArrayList<Resume>();
		JSONArray resumes = (JSONArray)personJSON.get(STUDENT_RESUMES);
		for(int i=0;i<resumes.size();i++) {
			JSONObject resume = (JSONObject)resumes.get(i);

			JSONArray educationsArray = (JSONArray)resume.get(RESUME_EDUCATIONS);
			ArrayList<Education> educations = new ArrayList<Education>();
			for(int j=0;j<educationsArray.size();j++) {
				JSONObject education = (JSONObject)educationsArray.get(j);
				String school = (String)education.get(EDUCATIONS_SCHOOL);
				int classYear = (int)education.get(EDUCATIONS_YEAR);
				String major = (String)education.get(EDUCATIONS_MAJOR);
				String minor = (String)education.get(EDUCATIONS_MINOR);
				double gpa = (double)education.get(EDUCATIONS_GPA);
				educations.add(new Education(school, classYear, major, minor, gpa));
			}

			ArrayList<String> skills = new ArrayList<String>();
			JSONArray skillsArray = (JSONArray)resume.get(RESUME_SKILLS);
			for(int k=0;k<skillsArray.size();k++) {
				JSONObject skill = (JSONObject)skillsArray.get(k);
				skills.add((String)skill.get(SKILLS_SKILL));
			}

			ArrayList<Experience> workExperiences = new ArrayList<Experience>();
			JSONArray workArray = (JSONArray)resume.get(RESUME_WORK);
			for(int k=0;k<workArray.size();k++) {
					JSONObject experience = (JSONObject)workArray.get(k);
					String title = (String)experience.get(EXPERIENCE_TITLE);
					String startDate = (String)experience.get(EXPERIENCE_START);
					String endDate = (String)experience.get(EXPERIENCE_END);
					String description = (String)experience.get(EXPERIENCE_DESCRIPTION);
					workExperiences.add(new Experience(title, startDate, endDate, description));
			}

			ArrayList<Experience> extraCurriculars = new ArrayList<Experience>();
			JSONArray extraArray = (JSONArray)resume.get(RESUME_EXTRACURRICULARS);
			for(int k=0;k<extraArray.size();k++) {
					JSONObject experience = (JSONObject)extraArray.get(k);
					String title = (String)experience.get(EXPERIENCE_TITLE);
					String startDate = (String)experience.get(EXPERIENCE_START);
					String endDate = (String)experience.get(EXPERIENCE_END);
					String description = (String)experience.get(EXPERIENCE_DESCRIPTION);
					workExperiences.add(new Experience(title, startDate, endDate, description));
			}

			ret.add(new Resume(student, educations, skills, workExperiences, extraCurriculars));
		}
		return ret;
	}

	private static ArrayList<Review> loadReviews(JSONObject personJSON) {
		ArrayList<Review> ret = new ArrayList<Review>();
		JSONArray reviewsArray = (JSONArray)personJSON.get(USER_REVIEWS);
		for(int i=0;i<reviewsArray.size();i++) {
			JSONObject review = (JSONObject)reviewsArray.get(i);
			int rating = (int)review.get(REVIEW_RATING);
			String reviewDes = (String)review.get(REVIEW_REVIEW);
			String revieweeID = (String)review.get(REVIEW_REVIEWEE);
			String reviewerID = (String)review.get(REVIEW_REVIEWER);
			ret.add(new Review(rating, reviewDes, reviewerID, revieweeID));
		}
		return ret;
	}

}
