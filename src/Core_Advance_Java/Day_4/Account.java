package Core_Advance_Java.Day_4;

import java.util.ArrayList;
import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}



interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;

    default boolean isValidAmount(double amount) {
        return amount > 0;
    }

    static void showRules() {
        System.out.println("Minimum balance must be maintained.");
    }
}



public abstract class Account implements BankOperations {
    protected int accountNumber;
    protected double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public abstract double calculateInterest();

    public void displayAccount() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}


class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public void deposit(double amount) {
        if (isValidAmount(amount)) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount)
            throw new InsufficientBalanceException("Insufficient balance!");
        balance -= amount;
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}


class CurrentAccount extends Account {
    private static final double MIN_BALANCE = 1000;

    public CurrentAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public void deposit(double amount) {
        if (isValidAmount(amount)) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance - amount < MIN_BALANCE)
            throw new InsufficientBalanceException("Minimum balance required!");
        balance -= amount;
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest
    }
}



class Customer {
    private int customerId;
    private String name;
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

    public void displayCustomer() {
//        System.out.println("Customer ID: " + customerId);
//        System.out.println("Name: " + name);
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
}



class Bank {
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public Customer getCustomer(int id) throws Exception {
        for (Customer c : customers) {
            if (c.getCustomerId() == id)
                return c;
        }
        throw new Exception("Customer not found");
    }
}


class Main {
    public static void main(String[] args) {
        int acc_cnt= 103;
        int cid = 2;
        ArrayList<Customer> customers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer(1, "John");
        customers.add(customer);

        customer.addAccount(new SavingsAccount(101, 5000));
        customer.addAccount(new CurrentAccount(102, 10000));

        while (true) {
            System.out.println("\n1.Deposit\n2.Withdraw\n3.Check Balance\n4.Interest\n5.Add customer\n6.Create Saving Account\n7. Create Current Account\n8. View your Accounts\n9. View Customers\n10.Exit");
            int choice = sc.nextInt();

            try {


                switch (choice) {
                    case 1:
                        System.out.print("Enter Account Number: ");
                        int accNo = sc.nextInt();
                        Account acc = customer.getAccount(accNo);
                        System.out.print("Amount: ");
                        acc.deposit(sc.nextDouble());
                        break;

                    case 2:
                        System.out.print("Enter Account Number: ");
                        accNo = sc.nextInt();
                        acc = customer.getAccount(accNo);
                        System.out.print("Amount: ");
                        acc.withdraw(sc.nextDouble());
                        break;

                    case 3:
                        System.out.print("Enter Account Number: ");
                        accNo = sc.nextInt();
                        acc = customer.getAccount(accNo);
                        acc.displayAccount();
                        break;

                    case 4:
                        System.out.print("Enter Account Number: ");
                        accNo = sc.nextInt();
                        acc = customer.getAccount(accNo);
                        System.out.println("Interest: " + acc.calculateInterest());
                        break;

                    case 5:

                        System.out.println("Enter name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                         customer = new Customer(customers.size(), name);
                         customers.add(customer);
                         cid++;
                        break;
                    case 6:
                        System.out.println("Enter Balance: ");
                        int  bal = sc.nextInt();
                        customer.addAccount(new SavingsAccount(acc_cnt, bal));
                        acc_cnt++;
                        break;
                    case 7:
                        System.out.println("Enter Balance: ");
                        int  bal1 = sc.nextInt();
                        customer.addAccount(new CurrentAccount(acc_cnt, bal1));
                        acc_cnt++;
                        break;
                    case 8:
                        customer.displayCustomer();
                        break;

                    case 9:
                        for(Customer customer1: customers){
                            System.out.println(customer1.toString());
                        }
                        break;
                    case 10:
                        System.exit(0);

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}




