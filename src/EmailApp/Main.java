package EmailApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Welcome message
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the email app!");
        System.out.println("What is your first name?");
        String firstName = input.next();
        System.out.println("What is your last name?");
        String lastName = input.next();
// Create user1
        Email user1 = new Email(firstName, lastName);
        int choice = 0;
        do {
            System.out.println("*********>> What would you like to do? \n1. Change your department \n2. Change your password \n3. Change your mail capacity \n4. Change your alter email \n5. Get user info \n6. Exit");
            choice = input.nextInt();
            switch (choice) {
                case 1 -> user1.askForDepartment();
                case 2 -> user1.changePassword();
                case 3 -> user1.setMailCapacity(1000);
                case 4 -> user1.setAlterEmail("<EMAIL>");
                case 5 -> user1.getUserInfo();
                case 6 -> System.out.println("Thank you for using our application.");
            }
        } while (choice != 6);
        input.close();

//        user1.askForDepartment();
//        user1.generateEmail();
//        user1.generatePassword();
//        user1.changePassword();
//        user1.setMailCapacity(1000);
//        user1.getUserInfo();

// Store in file
        user1.storeInFile();
    }
}
