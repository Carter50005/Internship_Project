import java.util.Scanner;

public class applicationUI {
    private Scanner scanner;
    private JobListingApplication application;
    private static final String WELCOME_MESSAGE = "***Welcome to our Internship Finder***";
    private String[] userOptions = {""};

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
            } else if(option.equals("Q")) {

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
        System.out.print.ln()
        if(application.login(username,password)) {
            System.out.println("---Loging In---")
        } else {
            System.out.println("Wong Password")
            login();
        }
    }

    private void createAccount() {
        System.out.println("Enter Username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        System.out.println("Are you a (S)tudent or (E)mployer")
        String account = scanner.nextLine();
        char type =  account.charAt(0);

    }

    
    public static void main(String[] args) {
        applicationUI start = new applicationUI();
        start.run();
    }
    
}
