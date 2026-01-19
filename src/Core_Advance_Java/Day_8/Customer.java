package Core_Advance_Java.Day_8;

import java.util.ArrayList;

public class Customer {
    private int customerId;
    private String name;
    // Dynamic Method Dispatch: Reference of Parent class Account and objects of child Current and Saving Account
    private ArrayList<Account> accounts = new ArrayList<>();

    public Customer(int id, String name) {
        this.customerId = id;
        this.name = name;
    }
    public int getCustomerId(){
        return this.customerId;
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public Account getAccount(int accNo) throws AccountNotFoundException {
        for (Account a : accounts) {
            if (a.getAccountNumber() == accNo)
                return a;
        }
        throw new AccountNotFoundException("Account not found!");
    }

    public void displayAccounts() {
        if(accounts.isEmpty()) {System.out.println(
                "No Accounts!"
        );
            return;}
        for (Account a : accounts)
            a.displayAccount();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", accounts count=" + accounts.size() +
                '}';
    }

    public void deductFee(int amount) throws InsufficientBalanceException {
        for (Account acc : accounts) {
            acc.withdraw(amount);
        }
    }
    public void addReward(int amount) throws InvalidAmountException {
        for (Account acc : accounts) {
            acc.deposit(amount);
        }
    }
}
