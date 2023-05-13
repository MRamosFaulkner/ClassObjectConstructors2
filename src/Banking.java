
import java.util.ArrayList;
import java.util.Scanner;

public class Banking {
    public static Scanner in = new Scanner(System.in);
    public static int input;
    public static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    public static void main(String[] args) {

        accounts.add(new BankAccount("Kyle", 6000, 0));
        accounts.add(new BankAccount("Joseph", 800, 1));
        accounts.add(new BankAccount("Gladys", 1000, 2));
        System.out.println("Hello world! Welcome to the bank of Faulkner & Sons!");
        System.out.println("Are you an existing customer? (-1 exit) \n1. Yes \n2. No");

        while(true) {
            try {
                input = Integer.parseInt(in.nextLine());
                if(input != 1 && input !=2 && input != -1) {
                    System.out.println("Please enter 1. Yes, 2. No, or -1 to exit: ");
                } else {
                    break;
                }
            } catch(Exception e) {
                System.out.println("Please enter 1. Yes, 2. No, or -1 to exit: ");
            }
        }

        if(input == 1) {
            System.out.println("What is your account number?");
            int accountNum;
            try {
                accountNum = Integer.parseInt(in.nextLine());
                if(accountNum < 0 || accountNum > accounts.size()-1) {
                    System.out.println("Sorry, this account number doesn't exist.");
                }
                mainMenu(accounts.get(accountNum));
            } catch(Exception e) {
                System.out.println("Please enter a valid number");
            }
        } else if(input == 2) {
            System.out.println("Let's make a new account!");
            BankAccount b = new BankAccount();
            accounts.add(b);
            b.setAccountNumber(accounts.size()-1);
            System.out.println("What is the name of the account holder?");
            b.setName(in.nextLine());
            System.out.println("What is the beginning balance for this account?");
            b.setBalance(Integer.parseInt(in.nextLine()));
            mainMenu(b);
        }

    }

    public static void mainMenu(BankAccount b) {
        boolean loop = true;
        System.out.println("\nHello " + b.getName());
        System.out.println("Welcome to the Main Menu, what would you like to do today?");
        while(loop) {
            System.out.println(
                    "1. To check account balance" +
                            "\n2. To make a withdrawal" +
                            "\n3. To make a deposit" +
                            "\n4. To make a transfer to another account" +
                            "\n0. To exit."
            );
            while(true) {
                try {
                    input = Integer.parseInt(in.nextLine());
                    if(input != 1 && input !=2 && input != 3 && input != 4 && input != 0) {
                        System.out.println("Please enter one of the options above: ");
                    } else if(input == 0) {
                        loop = false;
                        break;
                    } else {
                        break;
                    }
                } catch(Exception e) {
                    System.out.println("Please enter one of the options above: ");
                }
            }
            switch(input) {
                case 1:
                    System.out.println("Your account balance is : $" + b.getBalance());
                    break;
                case 2:
                    System.out.println("How much would you like to withdraw?");
                    double withdrawalAmount;
                    while(true) {
                        try {
                            withdrawalAmount = Integer.parseInt(in.nextLine());
                            break;
                        } catch(Exception e) {
                            System.out.println("Please enter a valid number:");
                        }
                    }
                    b.withdrawal(withdrawalAmount);
                    System.out.println("Withdrawal of " + withdrawalAmount + " successful.");
                    System.out.println("Your new balance is " + b.getBalance());
                    break;
                case 3:
                    System.out.println("How much would you like to deposit?");
                    double depositAmount;
                    while(true) {
                        try {
                            depositAmount = Integer.parseInt(in.nextLine());
                            break;
                        } catch(Exception e) {
                            System.out.println("Please enter a valid number:");
                        }
                    }
                    b.deposit(depositAmount);
                    System.out.println("Deposit of " + depositAmount + " successful.");
                    System.out.println("Your new balance is " + b.getBalance());
                    break;
                case 4:
                    System.out.println("Please enter the account number to transfer to:");
                    int accountNum;
                    double transferAmount;
                    while(true) {
                        try {
                            accountNum = Integer.parseInt(in.nextLine());
                            if(accountNum < 0 || accountNum > accounts.size()-1) {
                                System.out.println("Sorry, this account doesn't exist.");
                                break;
                            }
                            System.out.println("Please enter the amount to transfer:");
                            while(true) {
                                try {
                                    transferAmount = Double.parseDouble(in.nextLine());
                                    break;
                                } catch(Exception e) {
                                    System.out.println("Please enter a valid amount");
                                }
                            }
                            b.transfer(accounts.get(accountNum), transferAmount);
                            System.out.println(transferAmount + " successfully transferred to " + accounts.get(accountNum).getName());
                            break;
                        } catch(Exception e) {
                            System.out.println("Please enter a valid number");
                        }
                    }
                case 0:
                    break;
            }
        }
    }

}