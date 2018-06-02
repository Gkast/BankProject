package Bank;

import static javax.swing.JOptionPane.*;

public final class BankAccount implements BankActions {

    private String firstName;
    private String lastName;
    private final String Male = "male";
    private String titleGender;
    private double balance;
    private double dept;

    public BankAccount(String firstName, String lastName, String gender) {

        this.firstName = firstName;
        this.lastName = lastName;
        titleGender = gender.toLowerCase().trim().equals(Male) ? "Mr." : "Miss ";
        balance = 0.0;
        dept = 0.0;
    }

    @Override
    public void withdraw(double amount) {

        if (amount > balance) {

            showMessageDialog(null,
                    String.format("You don't have enough money to withdraw that amount %s %s",
                            titleGender, lastName), "", ERROR_MESSAGE);

        } else {

            balance -= amount;
            showMessageDialog(null, String.format("The withdrawal was successful %s %s",
                    titleGender, lastName), "Withdrawal", INFORMATION_MESSAGE);
        }
    }

    @Override
    public void deposit(double amount) {

        balance += amount;
        showMessageDialog(null, String.format("The deposit was successful %s %s",
                titleGender, lastName), "Deposit", INFORMATION_MESSAGE);
    }

    @Override
    public void loan(double amount) {

        dept += amount;
        showMessageDialog(null, String.format("You just got a loan %s %s",
                titleGender, lastName), "Deposit", INFORMATION_MESSAGE);
    }

    @Override
    public void payLoanWithCash(double amount) {

        if (amount > dept) {

            double remainingAmount;

            remainingAmount = amount - dept;
            dept = 0;
            balance += remainingAmount;

            showMessageDialog(null, "You have payed successfully your loan",
                    "Dept Payed", INFORMATION_MESSAGE);

        } else if (amount < dept) {

            dept -= amount;

            showMessageDialog(null, "You have a remaining dept of " + dept + "€",
                    "Remaining Dept", INFORMATION_MESSAGE);

        } else {

            dept = 0;

            showMessageDialog(null, "You have payed successfully your loan",
                    "Dept Payed", INFORMATION_MESSAGE);
        }
    }

    @Override
    public void payLoanFromBalance(double amount) {

        if (amount > balance) {

            showMessageDialog(null,
                    "You don't have enough money in your balance to pay your dept with that amount of money",
                    "Not Enough Money", ERROR_MESSAGE);

        }
        if (amount < balance) {

            dept -= amount;
            balance -= amount;

            showMessageDialog(null, "You have a remaining dept of " + dept + "€"
                            + " and your balance has left " + balance + "€",
                    "Remaining Dept", INFORMATION_MESSAGE);

        } else {

            if (dept == amount) {

                dept = 0;

                showMessageDialog(null, "You have payed successfully your loan",
                        "Dept Payed", INFORMATION_MESSAGE);
            } else {

                showMessageDialog(null, "You have a remaining dept of " + dept + "€"
                                + " and your balance has left " + balance + "€",
                        "Remaining Dept", INFORMATION_MESSAGE);
            }
        }

    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public double checkDept() {
        return dept;
    }
}
