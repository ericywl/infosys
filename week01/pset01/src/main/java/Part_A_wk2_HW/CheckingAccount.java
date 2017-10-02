package Part_A_wk2_HW;

import Part_A_wk1_cohort.Account;

public class CheckingAccount extends Account {
    public CheckingAccount(int id, double balance) {
        super(id, balance);
    }

    public void withdraw(int amount) {
        if (this.getBalance() - amount < -5000) {
            System.out.println("over limit");
        } else {
            super.withdraw(amount);
        }
    }
}
