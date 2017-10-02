package Part_A_wk1_cohort;

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private static double annualInterestRate = 0;
    private Date dateCreated;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account() {
        this(0, 0);
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public int getId() {
        return this.id;
    }

    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12.0;
    }

    public double getMonthlyInterest() {
        return (this.balance * this.getMonthlyInterestRate()) / 100.0;
    }

    public void withdraw(int amount) {
        if (amount > 0) {
            this.balance -= amount;
        }
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }
}
