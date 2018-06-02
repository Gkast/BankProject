package Bank;

public interface BankActions {

    void withdraw(double amount);

    void deposit(double amount);

    void loan(double amount);

    void payLoanWithCash(double amount);

    void payLoanFromBalance(double amount);

    double checkBalance();

    double checkDept();

}
