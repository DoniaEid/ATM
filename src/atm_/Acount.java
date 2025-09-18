package atm_;

import java.util.Random;

public class Acount {

    private String pin;
    private double balance;
    private Person owner;
    private int cardNumber;
    Random num = new Random();

    public Acount() {
    }

    public Acount(String pin, double balance, Person owner) {
        this.pin = pin;
        this.balance = balance;
        this.owner = owner;
        this.cardNumber = 1 + num.nextInt(10000);
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public Person getOwner() {
        return owner;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public Random getNum() {
        return num;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setNum(Random num) {
        this.num = num;
    }

    public String getAccountInfo() {
        StringBuilder sb = new StringBuilder();
        System.out.println("");
        sb.append("=== Account Information ===\n");
        sb.append("Owner: ").append(owner.getName()).append("\n");
        sb.append("Owner ID: ").append(owner.getId()).append("\n");
        sb.append("Card Number: ").append(cardNumber).append("\n");
        sb.append("PIN: ").append(this.pin).append("\n");
        sb.append(String.format("Balance: %.2f\n", balance));
        sb.append("===========================\n");
        return sb.toString();
    }

    public void printAccountInfo() {
        System.out.println(getAccountInfo());
    }

    public double Inquiry() {
        return this.balance;
    }

    public void Withdraw(double amount) {
      
        if (amount < 0) {
            System.out.println("Invalid amount. You cannot deposit zero or negative money.");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
            return;
        }
        if (amount == this.balance) {
            this.balance = 0;
            System.out.println("All your balance has been withdrawn. Your balance is now 0.");
        } else {
            this.balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is: " + getBalance());

        }
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount. You cannot deposit zero or negative money.");

        } else {
            this.balance += amount;
            System.out.println("Deposit successful. Your new balance is: " + getBalance());

        }
    }

}
