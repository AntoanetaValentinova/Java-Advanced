package BankAccount;

public class BankAccount {
    private static int idCount=1;
    private static double interestRate=0.02;

    private double balance;
    private double interest;
    private int id;

    public BankAccount() {
        this.id=idCount++;
        this.interest=interestRate;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double setInterest () {
        return this.balance*interestRate;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public double getInterest(double years) {
        return interestRate*years*this.balance;
    }

    public void deposit (double amount) {
        this.balance+=amount;
    }
}
