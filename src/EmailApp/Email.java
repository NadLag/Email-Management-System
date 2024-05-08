package EmailApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Email {
    // Setting up the variables
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int mailCapacity;
    private String alterEmail;
    public Scanner input = new Scanner(System.in);

    // Setting up the constructors
    public Email(String firstName, String lastName, String department, String email, String password, int mailCapacity, String alterEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = email;
        this.password = password;
        this.mailCapacity = 500;
        this.alterEmail = alterEmail;
        System.out.println("Welcome " + this.firstName + " " + this.lastName + "!");
    }

    public Email(String firstName, String lastName) {
        this(firstName, lastName, "N/A", "N/A", "password", 0, "N/A");
    }

    // Generate email method
    public void generateEmail() {
        String email = this.firstName + "." + this.lastName + "@" + this.department + ".com";
        System.out.println("Your email is: " + email.toLowerCase());
    }

    // Asking for department
    void askForDepartment() {
        System.out.println("What department are you in? \n1. Computer Science \n2. Mathematics \n3. Engineering.");
        boolean departmentValid = false;
        do {
            switch (input.nextInt()) {
                case 1 -> {
                    this.department = "CS";
                    departmentValid = true;
                }
                case 2 -> {
                    this.department = "Math";
                    departmentValid = true;
                }
                case 3 -> {
                    this.department = "Engineering";
                    departmentValid = true;
                }
                default -> {
                    System.out.println("Invalid department, please try again.");
                    askForDepartment();
                }
            }
        } while (!departmentValid);
        System.out.println("Your department is " + this.department + ".");
    }

    // generate password method
    public void generatePassword() {
        Random rdm = new Random();
        this.password = this.firstName + this.lastName + rdm.nextInt(10_000);
        System.out.println("Your password is: " + password);
    }

    //  Change password method
    public void changePassword() {
        System.out.println("What is your current password?");
        String currentPassword = input.next();
        if (currentPassword.equals(this.password)) {
            System.out.println("What is your new password?");
            this.password = input.next();
            System.out.println("Your password has been changed to: " + this.password);
        } else {
            System.out.println("Your current password is incorrect.");
        }
    }


    //  Set mail capacity method
    public void setMailCapacity(int mailCapacity) {
        System.out.println("Your current mail capacity is: " + mailCapacity);
        System.out.println("What is your new mail capacity?");
        this.mailCapacity = input.nextInt();
        System.out.println("Your mail capacity has been changed to: " + mailCapacity);
    }


    //  Set alter email method
    public void setAlterEmail(String alterEmail) {
        System.out.println("Your current alter email is: " + alterEmail);
        System.out.println("What is your new alter email?");
        this.alterEmail = input.next();
        System.out.println("Your alter email has been changed to: " + alterEmail);
    }

    // Get user info method
    public void getUserInfo() {
        System.out.println("Your first name is: " + this.firstName);
        System.out.println("Your last name is: " + this.lastName);
        System.out.println("Your department is: " + this.department);
        System.out.println("Your email is: " + this.email);
        System.out.println("Your password is: " + this.password);
        System.out.println("Your mail capacity is: " + this.mailCapacity);
        System.out.println("Your alter email is: " + this.alterEmail);
        System.out.println("Thank you for using our application.");
    }

    // Store in file method
    public void storeInFile() {
        try {
            String fileName = this.firstName + "." + this.lastName + ".txt";
            String fileContent = this.firstName + "\n" + this.lastName + "\n" + this.department + "\n" + this.email + "\n" + this.password + "\n" + this.mailCapacity + "\n" + this.alterEmail;
            File file = new File(fileName);
//            boolean fileCreated = file.createNewFile();
            FileWriter in = new FileWriter(file);
            in.write(fileContent);
            in.close();
            System.out.println("Your information has been saved to " + fileName + ".");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}