import java.util.Scanner;
import java.util.ArrayList;

public class applicationUI {
    private Scanner scanner;
    private JobListingApplication application;
    private static final String WELCOME_MESSAGE = "***Welcome to our Internship Finder***";
    private String[] studentOptions = {"Edit Account", "Apply for Job", "Create Resume", "Add Reveiw", "Search Jobs", "logout"};
    private String[] employerOptions = {"Edit Account", "Add Listing", "Search Applicats", "Veiw Listings", "logout"};
    private String[] adminOptions = {"Edit Account", "Edit Reveiw", "Delete Account", "logout"};
    private String[] studentAccount = {"Name","Email Adress","Education", "Work Experience", "Extracurricular Activities", "Go back"};
    private String[] employerAccount = {"Company Name","Company Description","Company Location","Job Listing","Go Back"};
    private String[] adminAccount = {"Name","Email Adress"};

    applicationUI() {
        scanner = new Scanner(System.in);
        application = JobListingApplication.getInstance();
    }

    public void run() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println("(L)og In, (C)reate Account, (Q)uit:");
        String option = scanner.nextLine();

        if(option.equalsIgnoreCase("L")){
            login();
        } else if(option.equalsIgnoreCase("C")) {
            createAccount();
            login();
        } else if(option.equals("Q")) {
            application.logout();
        }
    }

    private void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println();
        if(application.login(username,password)) {
            System.out.println("---Loging In---");
            mainMenu();
        } else {
            System.out.println("Wong Password");
            run();
        }
    }

    private void displayMainMenu(String[] options) {
        System.out.println("*****Main Menu*****");
        for(int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ". " + options[i]);
        }
        System.out.println("\n");

    }

    private void mainMenu() {
        boolean running = true;
        while(running) {
            if(application.findAccountType().equalsIgnoreCase("s")) {
                displayMainMenu(studentOptions);
                int option = selectOption();
                if(option == 1){
                    editAccount();
                } else if(option == 2) {
                    applyForJob();
                } else if(option == 3) {
                    createResume();
                } else if(option == 4) {
                    addReveiw();
                } else if(option == 5) {
                    searchJobs();
                } else if(option == 6) {
                    outResume();
                } else if(option == 7) {
                    application.logout();
                }else {
                    mainMenu();
                }
            } if(application.findAccountType().equalsIgnoreCase("a")) {
                displayMainMenu(adminOptions);
                int option = selectOption();
                if(option == 1){
                    editAdminAccount();
                } else if(option == 2) {
                    editReview();
                } else if(option == 3) {
                    deleteAccount();
                } else if(option == 4) {
                    application.logout();
                }else {
                    mainMenu();
                }
            } if(application.findAccountType().equalsIgnoreCase("e")) {
                displayMainMenu(employerOptions);
                int option = selectOption();
                if(option == 1){
                    editEmployerAccount();
                } else if(option == 2) {
                    addListing();
                } else if(option == 3) {
                    searchApplicants();
                } else if(option == 4) {
                    viewListing();
                } else if(option == 5) {
                    application.logout();
                }else {
                    mainMenu();
                }
            }
        }
    }
    private void outResume() {

    }

    private void addListing() {
        System.out.println("Create new job listing:");
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter posted date:");
        String postedDate = scanner.nextLine();
        System.out.println("Enter expiration date:");
        String expirationDate = scanner.nextLine();
        System.out.println("Enter location:");
        String location = scanner.nextLine();
        System.out.println("Enter job pay:");
        String jobPay = scanner.nextLine();
        JobListing listing = application.createListing(title, postedDate, expirationDate, location, jobPay);
        addDesiredSkill(listing);
        application.addJobListing(listing);
        System.out.println("Add another job listing? y/n");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            addListing();
        }
    }

    private void addDesiredSkill(JobListing listing) {
        System.out.println("Add desired skill:");
        String skill = scanner.nextLine();
        listing.addDesiredSkill(skill);
        System.out.println("Add another desired skill? y/n");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            addDesiredSkill(listing);
        }
    }

    private int selectOption() {
        System.out.println("Select an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    private void editAccount() {
        System.out.println("Which part of your account would you like to edit");
        for(int i=0;i<studentAccount.length;i++) {
            System.out.println((i+1)+". "+studentAccount[i]);
        }
        String option = String.valueOf(selectOption());
        if(option == "1") {
            editName();
        } else if(option == "2") {
            editEmailAdress();
        } else if(option == "3") {
            editEducation();
        } else if(option == "4") {
            editWorkExperience();
        } else if(option == "5") {
            editExtracuriculars();
        } else if(option == "6") {
            mainMenu();
        }
    }

    private void editName() {
        System.out.println("What is your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("What is your last name: ");
        String lastName = scanner.nextLine();
        editAccount();
    }

    private void editEmailAdress() {
        System.out.println("What is your email adress: ");
        String email = scanner.nextLine();
        editAccount();
    }

    private void editEducation() {
        System.out.println("Would you like to (A)dd, (D)elete, or (E)dit your education list((G)o back): ");
        String action = scanner.nextLine();
        if(action.equalsIgnoreCase("a")) {
            addEducation();
        } else if(action.equalsIgnoreCase("d")) {
            deleteEducation();
        } else if(action.equalsIgnoreCase("e")){
            editEducationItem();
        } else if(action.equalsIgnoreCase("g")) {
            editAccount();
        }
    }

    private void addEducation() {
        System.out.println("What is the name of the school: ");
        String name = scanner.nextLine();
        System.out.println("What is your class year: ");
        String year = scanner.nextLine();
        int classYear = Integer.parseInt(year);
        System.out.println("What is your major:");
        String major = scanner.nextLine();
        System.out.println("What is your minor:");
        String minor = scanner.nextLine();
        System.out.println("What is your gpa:");
        String gpa = scanner.nextLine();
        double GPA = Double.parseDouble(gpa);
    }

    private void deleteEducation() {

    }

    private void editEducationItem() {
        System.out.println("What Item would you Like to edit");
        String[] educationItems = {". School Name", ". Class Year", ". Major", ". Minor", ". Gpa", ". Go Back"};
        for(int i = 0; i < educationItems.length; i++) {
            System.out.println((i+1) + educationItems[i]);
        }
        String option = scanner.nextLine();
        int num = Integer.parseInt(option);
        if(num == 1) {
            System.out.println("What is your School Name: ");
            String name = scanner.nextLine();
        } else if(num == 2) {
            System.out.println("What is your class year: ");
            String classYear = scanner.nextLine();
            int ClassYear = Integer.parseInt(classYear);
        } else if(num == 3) {
            System.out.println("What is your major: ");
            String major = scanner.nextLine();
        } else if(num == 4) {
            System.out.println("What is your minor: ");
            String minor = scanner.nextLine();
        } else if(num == 5) {
            System.out.println("What is your gpa: ");
            String gpa = scanner.nextLine();
            Double GPA = Double.parseDouble(gpa);
        } else if(num == 6) {
            editEducation();
        }
    }

    private void editWorkExperience() {
        System.out.println("Would you like to (A)dd, (D)elete, or (E)dit your work experience list((G)o back): ");
        String action = scanner.nextLine();
        if(action.equalsIgnoreCase("a")) {
            addWorkExperience();
        } else if(action.equalsIgnoreCase("d")) {
            deleteWorkExperience();
        } else if(action.equalsIgnoreCase("e")){
            editWorkExperienceItem();
        } else if(action.equalsIgnoreCase("g")) {
            editAccount();
        }
    }

    private void addWorkExperience() {
        System.out.println("What was the title of your experience: ");
        String title = scanner.nextLine();
        System.out.println("What was the start date:");
        String startDate = scanner.nextLine();
        System.out.println("What was the end date:");
        String endDate = scanner.nextLine();
        System.out.println("Enter a description of the Experience");
        String description = scanner.nextLine();
        editWorkExperience();
    }

    private void addWorkExperience(Resume resume) {
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter start date:");
        String startDate = scanner.nextLine();
        System.out.println("Enter end date:");
        String endDate = scanner.nextLine();
        System.out.println("Enter description: ");
        String description  = scanner.nextLine();
        resume.addWorkExperience(new Experience(title, startDate, endDate, description));;
        System.out.println("Add another work experience? y/n");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            addWorkExperience(resume);
        }
    }

    private void addExtracurricular(Resume resume) {
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter start date:");
        String startDate = scanner.nextLine();
        System.out.println("Enter end date:");
        String endDate = scanner.nextLine();
        System.out.println("Enter description: ");
        String description  = scanner.nextLine();
        resume.addExtraCurricular(new Experience(title, startDate, endDate, description));;
        System.out.println("Add another extracurricular? y/n");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            addExtracurricular(resume);
        }
    }

    private void deleteWorkExperience() {

    }

    private void editWorkExperienceItem() {
        System.out.println("Which Item would you like to edit:");
        String[] workExperience = {". Title",". Start date", ". End date", ". Description", "Go Back"};
        for(int i = 0; i < workExperience.length; i++) {
            System.out.println((i+1) + workExperience[i]);
        }
        String option = scanner.nextLine();
        int num = Integer.parseInt(option);
        if(num == 1) {
            System.out.println("What is the title of the position: ");
            String title = scanner.nextLine();
        } else if(num ==2) {
            System.out.println("What was the start date of the position: ");
            String startDate = scanner.nextLine();
        } else if(num == 3) {
            System.out.println("What was the end date of the position");
            String endDate = scanner.nextLine();
        } else if(num == 4) {
            System.out.println("What is the description of the position: ");
            String description = scanner.nextLine();
        } else if(num == 5) {
            editWorkExperience();
        } else {
            System.exit(0);
        }

        System.out.println("");
    }

    private void editExtracuriculars() {
        System.out.println("Would you like to (A)dd, (D)elete, or (E)dit your Extra Curriculars list((G)o back): ");
        String action = scanner.nextLine();
        if(action.equalsIgnoreCase("a")) {
            addExtraCurricular();
        } else if(action.equalsIgnoreCase("d")) {
            deleteExtraCurricular();
        } else if(action.equalsIgnoreCase("e")){
            editExtraCurricularItem();
        } else if(action.equalsIgnoreCase("g")) {
            editAccount();
        }
    }

    private void addExtraCurricular() {
        System.out.println("What was the title of your Extra Curricular Activity");
        String title = scanner.nextLine();
        System.out.println("What was the start date of your Extra Curricular Activity");
        String startDate = scanner.nextLine();
        System.out.println("What was the end date of your Extra Curricular Activity");
        String endDate = scanner.nextLine();
        System.out.println("What is the description of the Extra Curricular Activity");
        String description = scanner.nextLine();
    }

    private void deleteExtraCurricular() {

    }

    private void editExtraCurricularItem() {
        System.out.println("Which Item would you like to edit");
        String[] extraCurriculars = {". Title",". Start Date",". End Date",". Description",". Go Back"};
        for(int i = 0; i < extraCurriculars.length; i++) {
            System.out.println((i+1) + extraCurriculars[i]);
        }
        String action = scanner.nextLine();
        int num = Integer.parseInt(action);
        if(num == 1) {
            System.out.println("What is the title");
            String title = scanner.nextLine();
        } else if(num == 2) {
            System.out.println("What is the start date");
            String startDate = scanner.nextLine();
        } else if(num == 3) {
            System.out.println("What is the end date");
            String endDate = scanner.nextLine();
        } else if(num == 4) {
            System.out.println("What is the description");
            String description = scanner.nextLine();
        } else if(num == 5) {
            editExtracuriculars();
        }
    }

    private void applyForJob() {
        System.out.println("Enter keyword for search:");
        String keyword = scanner.nextLine();
        ArrayList<JobListing> listings = application.searchListings(keyword);
        for(int i=0;i<listings.size();i++) {
            System.out.println(listings.get(i));
            System.out.println("(A)pply, (N)ext, (B)ack, or (E)xit:");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("a")) {
                application.applyStudent(listings.get(i));
            }
            else if(answer.equalsIgnoreCase("b")) {

            }
            else if(answer.equalsIgnoreCase("e")) {
                break;
            }
        }
    }

    private void createResume() {
        Resume resume = application.createResume();
        System.out.println("Add an education:");
        addEducation(resume);
        System.out.println("Add skills:");
        addSkills(resume);
        System.out.println("Add a work experience:");
        addWorkExperience(resume);
        System.out.println("Add an extracurricular:");
        addExtracurricular(resume);
        application.addResume(resume);
        System.out.println("Add another resume? y/n");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            createResume();
        }
    }

    private void addSkills(Resume resume) {
        System.out.println("Enter skill:");
        String skill = scanner.nextLine();
        resume.addSkill(skill);
        System.out.println("Add another skill? y/n");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            addSkills(resume);
        }
    }

    private void addEducation(Resume resume) {
        System.out.println("Enter your school:");
        String school = scanner.nextLine();
        System.out.println("Enter your class year:");
        String classYear = scanner.nextLine();
        System.out.println("Enter your major:");
        String major = scanner.nextLine();
        System.out.println("Enter your minor");
        String minor = scanner.nextLine();
        System.out.println("Enter your gpa");
        String gpa = scanner.nextLine();
        resume.addEducation(new Education(school, Integer.parseInt(classYear), major, minor, Double.parseDouble(gpa)));
        System.out.println("Add another education? y/n");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            addEducation();
        }
    }

    private void addReveiw() {

    }

    private void searchJobs() {
        System.out.println("Enter title of job:");
        String keyword = scanner.nextLine();
        ArrayList<JobListing> listings = application.searchListings(keyword);
        for(int i=0;i<listings.size();i++) {
        System.out.println(listings.get(i));
        }
    }

    private void createAccount() {
        System.out.println("Enter Username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        System.out.println("Are you a (S)tudent or (E)mployer");
        String account = scanner.nextLine();
        String type = String.valueOf(account.charAt(0));
        if(type.equalsIgnoreCase("s")) {
            System.out.println("Enter student ID:");
            String id = scanner.nextLine();
            System.out.println("Enter first name:");
            String firstName = scanner.nextLine();
            System.out.println("Enter last name:");
            String lastName = scanner.nextLine();
            System.out.println("Enter email:");
            String email = scanner.nextLine();
            application.createStudentAccount(username, password, id, firstName, lastName, email);
        }
        else if(type.equalsIgnoreCase("e")) {
            System.out.println("Enter company name:");
            String aName = scanner.nextLine();
            System.out.println("Enter company description:");
            String aDescription = scanner.nextLine();
            System.out.println("Enter company location:");
            String aLocation = scanner.nextLine();
            application.createEmployerAccount(username, password, aName, aDescription, aLocation);
        }
        if(application.login(username, password)) {
            mainMenu();
        }
    }

    private void editEmployerAccount() {
        System.out.println("Which part of your account would you like to edit");
        for(int i = 0; i < employerAccount.length; i++) {
            System.out.println((i+1) + employerAccount[i]);
            if(selectOption() == 1) {
                editCompanyName();
            } else if(selectOption() == 2) {
                editCompanyDescription();
            } else if(selectOption() == 3) {
                editCompanyLocation();
            } else if(selectOption() == 4) {
                mainMenu();
            }
        }
    }

    private void editCompanyName() {
            String CompanyName = scanner.nextLine();
            System.out.println("What is the company name: ");
            editCompanyName();
        }

    private void editCompanyDescription () {
            String companyDescription = scanner.nextLine();
            System.out.println("What is the company description: ");
            editCompanyDescription();
    }

    private void editCompanyLocation () {
            String companyLocation = scanner.nextLine();
            System.out.println("What is the company location: ");
            editCompanyDescription();
    }

<<<<<<< HEAD
    private void searchApplicants() {

    }

    private void viewListing() {
        ArrayList<JobListing> listings = application.getUserListings();
        for(JobListing listing : listings) {
            System.out.println(listing+"\n(V)iew applicants, (N)ext, or (E)xit?");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("v")) {
                viewApplicants(application.getStudents(), listing);
            }
            else if(answer.equalsIgnoreCase("e")) {
                return;
            }
        }
    }

    private void viewApplicants(ArrayList<Student> students, JobListing listing) {
        for(Student student : students) {
            for(String id : listing.getApplicantIDS()) {
                if(student.getUUID().equalsIgnoreCase(id)) {
                    System.out.println(student+"\n(V)iew resume, (N)ext, or (E)xit?");
                    String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("v")) {
                        for(Resume resume : student.getResumes()) {
                            System.out.println(resume);
                            break;
                        }
                    }
                    else if(answer.equalsIgnoreCase("e")) {
                        return;
                    }
                }
            }
        }
    }
=======
   private void searchApplicants() {

   }

   private void viewListing() {
    System.out.println("Enter title of job:");
    String keyword = scanner.nextLine();
    ArrayList<JobListing> listings = application.searchListings(keyword);
    for(int i=0;i<listings.size();i++) {
    System.out.println(listings.get(i));
    }
   }
>>>>>>> 4210e94fd5b402ee9fad1d464b06bbd5d0d7663f

   private void editAdminAccount() {
    System.out.println("Which part of your account would you like to edit");
    for(int i = 0; i < adminAccount.length; i++) {
        System.out.println((i+1) + adminAccount[i]);
        if(selectOption() == 1) {
            editName();
        }else if(selectOption() == 2) {
            editEmailAdress();
        } else if(selectOption() == 3) {
            mainMenu();
        }
    }
}

    private void editReview() {

    }

    private void deleteAccount() {

    }
    public static void main(String[] args) {
        applicationUI start = new applicationUI();
        start.run();
    }

}
