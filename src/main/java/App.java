import ActionTools.ActionListener;
import Bank.BankAccount;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public final class App {

    public static void main(String[] args) {

        JLabel welcomeLabel = new JLabel("Welcome to our bank", SwingConstants.CENTER);

        showMessageDialog(null, welcomeLabel, "Welcome", PLAIN_MESSAGE);

        String firstName;
        String lastName;
        String gender;

        try {

            firstName = showInputDialog(null, "Enter your first name",
                    "First Name", INFORMATION_MESSAGE);
            if (firstName == null)
                throw new NullPointerException();

            lastName = showInputDialog(null, "Enter your last name",
                    "Last Name", INFORMATION_MESSAGE);
            if (lastName == null)
                throw new NullPointerException();

            gender = showInputDialog(null, "Enter your gender",
                    "Gender", INFORMATION_MESSAGE);
            if (gender == null)
                throw new NullPointerException();

            BankAccount account = new BankAccount(firstName, lastName, gender);

            new ActionListener().readAction(account);

        } catch (NullPointerException e) {
            showMessageDialog(null, "Exiting Bank Application",
                    "Exiting", WARNING_MESSAGE);
        }
    }
}
