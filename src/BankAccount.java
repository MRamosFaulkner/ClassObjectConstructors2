
public class BankAccount {
    private double balance;
    private String accountHolder;
    private int accountNumber;

    public BankAccount() {}

    public BankAccount(String accountHolderName, double balance, int accountNumber) {
        accountHolder = accountHolderName;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void setName(String name) {
        accountHolder = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountNumber(int num) {
        accountNumber = num;
    }

    public String getName() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double depositAmount) {
        balance += depositAmount;
    }

    public void withdrawal(double withdrawalAmount) {
        balance -= withdrawalAmount;
    }

    public void transfer(BankAccount a, double amount) {
        this.withdrawal(amount);
        a.deposit(amount);
    }

    public String toString() {
        return ("\n" + accountHolder + "'s account balance: $" + balance);
    }

}