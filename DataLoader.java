import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{
    
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				String username = (String)personJSON.get(USER_USERNAME);
				String password = (String)personJSON.get(USER_PASSWORD);
				char userType = (char)personJSON.get(USER_TYPE);
				String uUID = (String)personJSON.get(USER_UUID);
				if(userType == 's') {
					users.add(getStudent(i, username, password, uUID, personJSON));
				}
				else if(userType == 'e') {
					users.add(getEmployer(i, username, password, uUID, personJSON));
				}
				else if(userType == 'a') {
					users.add(new Admin(username, password, uUID));
				}
				/*JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				String userName = (String)personJSON.get(USER_USER_NAME);
				String firstName = (String)personJSON.get(USER_FIRST_NAME);
				String lastName = (String)personJSON.get(USER_LAST_NAME);
				int age = ((Long)personJSON.get(USER_AGE)).intValue();
				String phoneNumber = (String)personJSON.get(USER_PHONE_NUMBER);
				
				users.add(new User(id, userName, firstName, lastName, age, phoneNumber));*/
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

	private static Student getStudent(int i, String username, String password, String uUID, JSONObject personJSON) {
		String firstName = (String)personJSON.get(STUDENT_FIRST_NAME);
		String lastName = (String)personJSON.get(STUDENT_LAST_NAME);
		String email = (String)personJSON.get(STUDENT_EMAIL);
		return new Student(username, password, uUID, firstName, lastName, email);
	} 

	private static Employer getEmployer(int i, String username, String password, String uUID, JSONObject personJSON) {
		String name = (String)personJSON.get(EMPLOYER_NAME);
		String description = (String)personJSON.get(EMPLOYER_DESCRIPTION);
		String location = (String)personJSON.get(EMPLOYER_LOCATION);
		int rating = (int)personJSON.get(EMPLOYER_RATING);
		return new Employer(username, password, name, description, location, rating);
	} 

}
