package ActionTools;

import Bank.BankAccount;

import static javax.swing.JOptionPane.*;

public final class ActionListener implements ActionListen {

    private ActionExecutor executor = new ActionExecutor();

    @Override
    public void readAction(BankAccount account) {

        try {

            String optionInput;

            optionInput = showInputDialog(null, "Type <<withdraw>> to withdraw money\n"
                            + "Type <<deposit>> to deposit money\n" + "Type <<check balance>> to check your balance\n"
                            + "Type <<loan>> to get a loan\n" + "Type <<pay loan>> to pay your loan\n"
                            + "Type <<check dept>> to pay your dept\n" + "Type <<exit>> to exit the application\n",
                    "Choose your action", INFORMATION_MESSAGE);

            if (optionInput == null)
                throw new NullPointerException();
            else
                optionInput = optionInput.toLowerCase().trim();

            switch (optionInput) {

                case "withdraw":

                    executor.executeAction("Withdraw", account);
                    readAction(account);
                    break;

                case "deposit":

                    executor.executeAction("Deposit", account);
                    readAction(account);
                    break;

                case "loan":

                    executor.executeAction("Loan", account);
                    readAction(account);
                    break;

                case "check balance":

                    executor.executeAction("Check Balance", account);
                    readAction(account);
                    break;

                case "pay loan":

                    if (account.checkDept() != 0) {
                        String choice;
                        choice = new PaymentChoice().method();

                        switch (choice) {

                            case "Cancel Payment":
                                showMessageDialog(null, "Canceling Payment Method",
                                        "Cancel", WARNING_MESSAGE);
                                break;

                            default:
                                executor.executeAction(choice, account);
                                break;
                        }

                    } else {
                        showMessageDialog(null, "You don't have a dept",
                                "No Dept", WARNING_MESSAGE);
                    }
                    readAction(account);
                    break;

                case "check dept":

                    executor.executeAction("Check Dept", account);
                    readAction(account);
                    break;

                case "exit":

                    executor.executeAction("Exit", account);
                    break;

                default:

                    showMessageDialog(null, "Wrong action\n" + "Try again!!!",
                            "", ERROR_MESSAGE);
                    readAction(account);
                    break;

            }
        } catch (NullPointerException e) {
            showMessageDialog(null, "Exiting Bank Application",
                    "Exiting", WARNING_MESSAGE);
        }

    }
}

