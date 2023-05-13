
import java.util.Scanner;

public class BankAccount {

    //Attributes that can only be used in this class (private)
    private String acctHolderName;
    private double acctBalance;
    private int acctNumber;

    //Constructor that takes the attributes as parameters to initialize
    public BankAccount(String acctHolderName, double acctBalance) {
        this.acctHolderName = acctHolderName;
        this.acctBalance = acctBalance;
        this.acctNumber = acctNumber;
    }

    public BankAccount() {
        Scanner scanner = new Scanner(System.in);

        String nameOfHolder;
        double startingBal;

        System.out.println("Are you an existing customer? (-1 to exit) \n1. Yes \n2.No");
        int answer = scanner.nextInt();

        if (answer == 1) {
            System.out.println("Please enter your account number: ");
            int acctNumber = scanner.nextInt();

            this.acctBalance = 1000.0;
            this.acctHolderName = "John Doe";
            this.acctNumber = acctNumber;
        } else if (answer == 2) {
            System.out.println("Let's make an account!");

            System.out.print("What is the beginning balance for the account? ");
            this.acctBalance = scanner.nextDouble();

            System.out.println("Account created successfully.");
        } else {
            System.out.println("Exiting program.");
            System.exit(0);
        }
    }


    //Different methods created
    public void deposit(double depositAmnt) {
        acctBalance += depositAmnt;
    }

    public void withdrawal (double amount) {
//        if (amount > this.acctBalance) {
//            System.out.println("Insufficient funds");
//        } else {
//            this.acctBalance = amount;
//        }
        acctBalance -= amount;
    }

    public void printDetails() {
        System.out.println("My balance is " + this.acctBalance + "\n");
    }

    public String toString() {
        return acctHolderName + "'s account balance: " + acctBalance;
    }

}