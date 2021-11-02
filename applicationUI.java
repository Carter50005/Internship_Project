import java.util.Scanner;
import java.util.ArrayList;

public class applicationUI {
    private Scanner scanner;
    private JobListingApplication application;
    private static final String WELCOME_MESSAGE = "***Welcome to our Internship Finder***";
    private String[] studentOptions = {"Edit Account", "Apply for Job", "Create Resume", "Add Reveiw", "Search Jobs", "logout"};
    private String[] employerOptions = {"Edit Account", "Add Listing", "Search Applicats", "Veiw Listings", "logout"};
    private String[] adminOptions = {"Edit Account", "Edit Reveiw", "Delete Account", "logout"};
    private String[] studentAccount = {"Name","Email Adress","Phone Number", "Go back"};
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

    private void editPhoneNumber() {
        System.out.println("what is your phone number: ");
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
            addEducation(resume);
        }
    }

    private void addReveiw() {

    }

    private void searchJobs() {

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
            System.out.println("Enter phone number:");
            String phoneNumber = scanner.nextLine();
            application.createStudentAccount(username, password, id, firstName, lastName, email, phoneNumber);
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
