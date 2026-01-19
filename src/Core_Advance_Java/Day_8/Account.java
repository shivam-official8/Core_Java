package Core_Advance_Java.Day_8;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public abstract class Account implements BankOperations {
    final ReadWriteLock lock = new ReentrantReadWriteLock();
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
        lock.readLock().lock();
        try{
            return balance;
        }
        finally {
            lock.readLock().unlock();
        }

    }

    public abstract double calculateInterest();

    public abstract void displayAccount() ;
}


class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException{
        lock.writeLock().lock();
        try{
            if (isValidAmount(amount)) {
                balance += amount;
            }else{
                throw new InvalidAmountException("Invalid Amount, Amount can't be Negative!");
            }
        }finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        lock.writeLock().lock();
        try{
            if (balance < amount)
                throw new InsufficientBalanceException("Insufficient balance!");
            balance -= amount;
        }finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
   public void displayAccount()  {
        System.out.println("Account Type: Saving Account");
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class CurrentAccount extends Account {
    private static final double MIN_BALANCE = 1000;

    public CurrentAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        lock.writeLock().lock();
        try{
            if (isValidAmount(amount)) {
                balance += amount;
            }else{
                throw new InvalidAmountException("Invalid Amount, Amount can't be Negative!");
            }
        }finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        lock.writeLock().lock();
        try{
            if (balance - amount < MIN_BALANCE)
                throw new InsufficientBalanceException("Minimum balance required!");
            balance -= amount;
        }finally {
            lock.writeLock().unlock();
        }

    }
    @Override
    public void displayAccount()  {
        System.out.println("Account Type: Current Account");
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest
    }
}



