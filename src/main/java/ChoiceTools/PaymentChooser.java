package ChoiceTools;

import static javax.swing.JOptionPane.*;

public final class PaymentChooser implements ChoiceReader {

    @Override
    public String paymentMethod() {

        int choice;
        String paymentChoice;

        choice = showConfirmDialog(null,
                "Do you want to pay your loan with cash?", "Payment Method",
                YES_NO_CANCEL_OPTION, QUESTION_MESSAGE);

        switch (choice) {

            case YES_OPTION:
                paymentChoice = "Pay Loan With Cash";
                break;

            case NO_OPTION:
                choice = showConfirmDialog(null,
                        "Do you want to pay your loan from balance?", "Payment Method",
                        YES_NO_CANCEL_OPTION, QUESTION_MESSAGE);

                switch (choice) {

                    case YES_OPTION:
                        paymentChoice = "Pay Loan From Balance";
                        break;

                    case NO_OPTION:
                        paymentChoice = "Cancel Payment";
                        break;

                    case CANCEL_OPTION:
                        paymentChoice = "Cancel Payment";
                        break;

                    default:
                        paymentChoice = "Cancel Payment";
                        break;

                }
                break;

            case CANCEL_OPTION:
                paymentChoice = "Cancel Payment";
                break;

            default:
                paymentChoice = "Cancel Payment";
                break;
        }

        return paymentChoice;
    }
}
