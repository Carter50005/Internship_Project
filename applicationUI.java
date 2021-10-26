import java.util.Scanner;

public class applicationUI {
    private Scanner scanner;
    private static final String WELCOME_MESSAGE = "***Welcome to our Internship Finder***";
    private String[] userOptions = {""};

    applicationUI() {
        scanner = new Scanner(System.in);
        UserList users  = UserList.getInstance();
        JobListingsList jobs = JobListingsList.getInstance();
    }

    public void run() {
        
        while(true) {
            System.out.println(WELCOME_MESSAGE);
            System.out.println("(L)og In, (C)reate Account, (Q)uit:");
            String option = scanner.nextLine();

            if(option.equalsIgnoreCase("L")){
                
            } else if(option.equalsIgnoreCase("C")) {

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
    public static void main(String[] args) {
        applicationUI start = new applicationUI();
        start.run();
    }
    
}
