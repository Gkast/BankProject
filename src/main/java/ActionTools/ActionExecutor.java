package ActionTools;

import Bank.BankAccount;

import static javax.swing.JOptionPane.*;

public final class ActionExecutor implements ActionExecute {

    @Override
    public void executeAction(String typeAction, BankAccount account) {

        String amountInput;
        double amount;

        switch (typeAction) {

            case "Withdraw":
                try {

                    amountInput = showInputDialog(null, "Type the amount you want to withdraw",
                            "Amount to Withdraw", PLAIN_MESSAGE);

                    amount = Double.parseDouble(amountInput);

                    if (amount <= 0) {
                        showMessageDialog(null,
                                "Type an amount, to withdraw, larger than zero next time",
                                "Wrong input", ERROR_MESSAGE);
                        break;
                    }

                    account.withdraw(amount);

                } catch (NullPointerException e) {
                    showMessageDialog(null, "Canceling withdrawal",
                            "Cancel", WARNING_MESSAGE);

                } catch (NumberFormatException e) {
                    showMessageDialog(null, "Type a number next time",
                            "Wrong input", ERROR_MESSAGE);
                }
                break;

            case "Deposit":
                try {

                    amountInput = showInputDialog(null, "Type the amount you want to deposit",
                            "Amount to Withdraw", PLAIN_MESSAGE);

                    amount = Double.parseDouble(amountInput);

                    if (amount <= 0) {
                        showMessageDialog(null,
                                "Type an amount, to deposit, larger than zero next time",
                                "Wrong input", ERROR_MESSAGE);
                        break;
                    }

                    account.deposit(amount);

                } catch (NullPointerException e) {
                    showMessageDialog(null, "Canceling deposit",
                            "Cancel", WARNING_MESSAGE);

                } catch (NumberFormatException e) {
                    showMessageDialog(null, "Type a number next time",
                            "Wrong input", ERROR_MESSAGE);
                }
                break;

            case "Loan":
                try {

                    amountInput = showInputDialog(null, "Type the amount you want to loan",
                            "Amount to get a Loan", PLAIN_MESSAGE);

                    amount = Double.parseDouble(amountInput);

                    if (amount <= 0) {
                        showMessageDialog(null,
                                "Type an amount, to get a loan, larger than zero next time",
                                "Wrong input", ERROR_MESSAGE);
                        break;
                    }

                    account.loan(amount);

                } catch (NullPointerException e) {
                    showMessageDialog(null, "Canceling loan",
                            "Cancel", WARNING_MESSAGE);

                } catch (NumberFormatException e) {
                    showMessageDialog(null, "Type a number next time",
                            "Wrong input", ERROR_MESSAGE);
                }
                break;

            case "Check Balance":
                if (account.checkBalance() == 0)
                    showMessageDialog(null, "You dont have any money in your balance",
                            "Balance", INFORMATION_MESSAGE);
                else
                    showMessageDialog(null, "Your balance is: " +
                            account.checkBalance() + "€", "Balance", INFORMATION_MESSAGE);
                break;

            case "Pay Loan With Cash":

                try {

                    amountInput = showInputDialog(null,
                            "Type the amount you want to pay",
                            "Amount to pay your dept", PLAIN_MESSAGE);

                    if (amountInput == null)
                        throw new NullPointerException();

                    amount = Double.parseDouble(amountInput);

                    if (amount <= 0) {
                        showMessageDialog(null,
                                "Type an amount, to pay your dept, larger than zero next time",
                                "Wrong input", ERROR_MESSAGE);
                        break;
                    }

                    account.payLoanWithCash(amount);
                    break;

                } catch (NullPointerException e) {
                    showMessageDialog(null, "Canceling payment",
                            "Cancel", WARNING_MESSAGE);

                } catch (NumberFormatException e) {
                    showMessageDialog(null, "Type a number next time",
                            "Wrong input", ERROR_MESSAGE);
                }
                break;

            case "Pay Loan From Balance":

                if (account.checkBalance() != 0) {
                    try {

                        amountInput = showInputDialog(null,
                                "You have in your balance " + account.checkBalance() + "€"
                                        + "\nType the amount you want pay from your balance",
                                "Amount to pay your dept", PLAIN_MESSAGE);

                        if (amountInput == null)
                            throw new NullPointerException();

                        amount = Double.parseDouble(amountInput);

                        if (amount <= 0) {
                            showMessageDialog(null,
                                    "Type an amount, to pay your dept, larger than zero next time",
                                    "Wrong input", ERROR_MESSAGE);
                            break;
                        }

                        account.payLoanFromBalance(amount);
                        break;

                    } catch (NullPointerException e) {
                        showMessageDialog(null, "Canceling payment",
                                "Cancel", WARNING_MESSAGE);

                    } catch (NumberFormatException e) {
                        showMessageDialog(null, "Type a number next time",
                                "Wrong input", ERROR_MESSAGE);
                    }

                } else {
                    showMessageDialog(null, "You don't have any money in your balance",
                            "No Money", WARNING_MESSAGE);
                }
                break;

            case "Check Dept":
                if (account.checkBalance() == 0)
                    showMessageDialog(null, "You don't have a dept",
                            "Dept", INFORMATION_MESSAGE);
                else
                    showMessageDialog(null, "Your dept is: " + account.checkDept() + "€",
                            "Dept", INFORMATION_MESSAGE);
                break;

            case "Exit":
                showMessageDialog(null, "Exiting Bank Application",
                        "Exiting", WARNING_MESSAGE);
                break;
        }
    }
}
