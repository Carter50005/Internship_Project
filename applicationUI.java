import java.util.Scanner;

public class applicationUI {
    private Scanner scanner;
    private JobListingApplication application;
    private static final String WELCOME_MESSAGE = "***Welcome to our Internship Finder***";
    private String[] studentOptions = {"Edit Account", "Apply for Job", "Create Resume", "Add Reveiw", "Search Jobs", "logout"};
    private String[] employerOptions = {"Edit Account", "Add Listing", "Search Applicats", "Veiw Listings", "logout"};
    private String[] adminOptions = {"Edit Account", "Edit Reveiw", "Delete Account", "logout"};

    applicationUI() {
        scanner = new Scanner(System.in);
        application = new JobListingApplication();
    }

    public void run() {

        while(true) {
            System.out.println(WELCOME_MESSAGE);
            System.out.println("(L)og In, (C)reate Account, (Q)uit:");
            String option = scanner.nextLine();

            if(option.equalsIgnoreCase("L")){
                login();
            } else if(option.equalsIgnoreCase("C")) {
                createAccount();
                login();
            } else if(option.equals("Q")) {
                break;
            } else {
                break;
            }
        }

    }

    private void displayMainMenu(String[] options) {
        System.out.println("*****Main Menu*****");
        for(int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ". " + options[i]);
        }
        System.out.println("\n");
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
            if(application.findAccountType() == 's') {
                displayMainMenu(studentOptions);
                if(selectOption() == 1){

                } else if(selectOption() == 2) {

                } else if(selectOption() == 3) {

                } else if(selectOption() == 4) {

                } else if(selectOption() == 5) {

                } else if(selectOption() == 6) {
                    System.exit(0);
                }else {
                    System.exit(0);
                }
            } if(application.findAccountType() == 'a') {
                displayMainMenu(adminOptions);
                if(selectOption() == 1){

                } else if(selectOption() == 2) {

                } else if(selectOption() == 3) {

                } else if(selectOption() == 4) {
                    System.exit(0);
                }else {
                    System.exit(0);
                }
            } if(application.findAccountType() == 'e') {
                displayMainMenu(employerOptions);
                if(selectOption() == 1){

                } else if(selectOption() == 2) {

                } else if(selectOption() == 3) {

                } else if(selectOption() == 4) {

                } else if(selectOption() == 5) {
                    System.exit(0);
                }else {
                    System.exit(0);
                }
            }
        } else {
            System.out.println("Wong Password");
        }
    }

    private int selectOption() {
        System.out.println("Select an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    private void createAccount() {
        System.out.println("Enter Username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        System.out.println("Are you a (S)tudent or (E)mployer");
        String account = scanner.nextLine();
        char type =  account.charAt(0);
        application.createAccount(username, password, type);
    }



    public static void main(String[] args) {
        applicationUI start = new applicationUI();
        start.run();
    }

}
