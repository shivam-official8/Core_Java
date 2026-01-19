package Core_Advance_Java.Day_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
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
            System.out.println("\n1.Deposit\n2.Withdraw\n3.Check Balance\n4.Interest\n5.Add customer\n6.Create Saving Account\n7. Create Current Account\n8. View your Accounts\n9. View Customers\n10. Withdraw Maintenance Fees (Multithreading)\n11. Deposit Reward (Multithreading)\n12.Exit");
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
                        customer = new Customer(customers.size()+1, name);
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
                        System.out.println("Enter Balance (Minimum 1000): ");
                        int  bal1 = sc.nextInt();
                        while(bal1<1000){
                            System.out.println("Minimum Balance required 1000");
                            bal1 = sc.nextInt();
                        }
                        customer.addAccount(new CurrentAccount(acc_cnt, bal1));
                        acc_cnt++;
                        break;
                    case 8:
                        customer.displayAccounts();
                        break;

                    case 9:
                        for(Customer customer1: customers){
                            System.out.println(customer1.toString());
                        }
                        break;
                    case 10:
                        ExecutorService executor = Executors.newFixedThreadPool(5);
                        List<Future<String>> results = new ArrayList<>();
                        for(Customer cus : customers){
                            results.add(executor.submit(() -> {
                                cus.deductFee(20);
                                return "Maintenance fee deducted for customer " + cus.getCustomerId();
                            }));

                            results.add(executor.submit(() -> {
                                cus.deductFee(10);
                                return "Platform fee deducted for customer " + cus.getCustomerId();
                            }));
                        }
                        for (Future<String> f : results) {
                            System.out.println(f.get());
                        }

                        executor.shutdown();
                        break;
                    case 11:
                        ExecutorService executor1 = Executors.newFixedThreadPool(5);
                        List<Future<String>> results1 = new ArrayList<>();
                        for(Customer cus : customers){
                            results1.add(executor1.submit(() -> {
                                cus.addReward(10);
                                return "Diwali reward added for customer " + cus.getCustomerId();
                            }));

                            results1.add(executor1.submit(() -> {
                                cus.addReward(5);
                                return "Annual reward added for customer " + cus.getCustomerId();
                            }));
                        }
                        for (Future<String> f : results1) {
                            System.out.println(f.get());
                        }

                        executor1.shutdown();
                        break;

                    case 12:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Input!");

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}



