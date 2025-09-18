package atm_;

import java.util.HashMap;
import java.util.Scanner;

public class ATM_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Acount> accounts = new HashMap<>();

        Person p1 = new Person("Donia Eid", "ID12345");
        Acount acc1 = new Acount("1111-2222-3333-4444", 1000.0, p1);
        accounts.put(acc1.getPin(), acc1);

        Person p2 = new Person("Ali Mohamed", "ID67890");
        Acount acc2 = new Acount("5555-6666-7777-8888", 500.0, p2);
        accounts.put(acc2.getPin(), acc2);

        Person p3 = new Person("Sara Ahmed", "ID24680");
        Acount acc3 = new Acount("9999-0000-1111-2222", 2000.0, p3);
        accounts.put(acc3.getPin(), acc3);

        Person p4 = new Person("Omar Ali", "ID13579");
        Acount acc4 = new Acount("3333-4444-5555-6666", 1500.0, p4);
        accounts.put(acc4.getPin(), acc4);

        System.out.println(" ==== Welcome to the ATM, have a nice day!==== \n");
        int attempts = 3;
        String pin = "";
        Acount currentAccount = null;

        while (attempts > 0) {
            System.out.print("Please enter your PIN: ");
            pin = scanner.nextLine();

            if (accounts.containsKey(pin)) {
                currentAccount = accounts.get(pin);
                break;
            } else {
                attempts--;
                System.out.println("Incorrect PIN. Attempts left: " + attempts);
            }
        }

        if (currentAccount == null) {
            System.out.println("You have run out of attempts. Please try again later.");
            return;
        }

        while (true) {

            System.out.println("1. Balance Inquiry");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Account Info");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Your account: " + currentAccount.getBalance());
                    break;

                case 2:
                    System.out.print("Enter the amount you want to withdraw: ");
                    double amount = scanner.nextDouble();
                    accounts.get(pin).Withdraw(amount);
                    break;
                case 3:
                    System.out.print("Enter the amount you want to deposit: ");
                    double a = scanner.nextDouble();
                    accounts.get(pin).deposit(a);
                    break;
                case 4:
                    System.out.println(accounts.get(pin).getAccountInfo());
                    break;
                case 5:
                    System.out.print("Thank you for using the ATM");
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        System.out.print(".");
                    }
                    System.out.println("\nGoodbye!");

                    return;

                default:
                    System.out.println("Invalid option. Please try again.");

            }

        }
    }

}