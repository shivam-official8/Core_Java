package Day_2.Topics.Attributes_and_Methods;
// Create a class BankAccount with attribute balance.
//Add methods:
//
//deposit(amount)
//
//withdraw(amount)
//
//displayBalance()
public class BankAccount {
    public int balance = 500;

    public void deposit(int amount){
        balance += amount;
        displayBalance();
    }
    public void withdraw(int amount){
        if(amount>balance){
            System.out.println("Not enough balance!");
        }else balance -= amount;
        displayBalance();
    }
    public void displayBalance(){
        System.out.println("Balance: "+balance);
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(200);
//        bankAccount.displayBalance();
        bankAccount.withdraw(10000);
//        bankAccount.displayBalance();
        bankAccount.withdraw(400);
//        bankAccount.displayBalance();

    }
}
