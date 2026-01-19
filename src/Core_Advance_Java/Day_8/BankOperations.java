package Core_Advance_Java.Day_8;

public interface BankOperations {
    void deposit(double amount) throws InvalidAmountException;
    void withdraw(double amount) throws InsufficientBalanceException;

    default boolean isValidAmount(double amount) {
        return amount > 0;
    }

    static void showRules() {
        System.out.println("Minimum balance must be maintained.");
    }
}

