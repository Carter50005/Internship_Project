import java.util.Scanner;

public class applicationUI {
    private Scanner scanner;
    private JobListingApplication application;
    private static final String WELCOME_MESSAGE = "***Welcome to our Internship Finder***";
    private String[] studentOptions = {"Edit Account", "Apply for Job", "Create Resume", "Add Reveiw", "Search Jobs", "logout"};
    private String[] employerOptions = {"Edit Account", "Add Listing", "Search Applicats", "Veiw Listings", "logout"};
    private String[] adminOptions = {"Edit Account", "Edit Reveiw", "Delete Account", "logout"};
    private String[] studentAccount = {"Name","Email Adress","Education", "Work Experience", "Extracurricular Activities", "Go back"};

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

                } else if(option == 2) {

                } else if(option == 3) {

                } else if(option == 4) {
                    application.logout();
                }else {
                    mainMenu();
                }
            } if(application.findAccountType().equalsIgnoreCase("e")) {
                displayMainMenu(employerOptions);
                int option = selectOption();
                if(option == 1){

                } else if(option == 2) {

                } else if(option == 3) {

                } else if(option == 4) {

                } else if(option == 5) {
                    application.logout();
                }else {
                    mainMenu();
                }
            }
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
        for(int i = 0; i < studentAccount.length; i++) {
            System.out.println((i+1) + studentAccount[i]);
            if(selectOption() == 1) {
                editName();
            } else if(selectOption() == 2) {
                editEmailAdress();
            } else if(selectOption() == 3) {
                editEducation();
            } else if(selectOption() == 4) {
                editWorkExperience();
            } else if(selectOption() == 5) {
                editExtracuriculars();
            } else if(selectOption() == 6) {
                mainMenu();
            }
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

    }

    private void deleteExtraCurricular() {

    }

    private void editExtraCurricularItem() {
        
    }

    private void applyForJob() {
        
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

    public static void main(String[] args) {
        applicationUI start = new applicationUI();
        start.run();
    }

}
