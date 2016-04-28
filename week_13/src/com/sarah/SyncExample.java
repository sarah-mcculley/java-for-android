package com.sarah;

class CheckingAccount {
    private int balance;

    CheckingAccount(int initialBalance) {
        balance = initialBalance;
    }

    synchronized public int withdraw(int amount) {
        if (amount <= balance) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
        }
        return balance;
    }
}
public class SyncExample {
    public static void main(String [] args) {
        CheckingAccount account = new CheckingAccount(100);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                for (int i=0; i < 10; i++) {
                    System.out.println(name + " tries to withdraw $10, balance:"
                            + account.withdraw(10));
                }
            }
        };

        Thread husband = new Thread(r);
        husband.setName("Husband");
        Thread wife = new Thread(r);
        wife.setName("Wife");

        husband.start();
        wife.start();
    }

}