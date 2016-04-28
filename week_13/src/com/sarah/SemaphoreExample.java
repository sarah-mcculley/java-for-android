package com.sarah;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class CheckingAccountTwo {
    private Semaphore permits = new Semaphore(1, true);
    private int balance;


    CheckingAccountTwo(int initialBalance) {
        balance = initialBalance;
    }

    public int withdraw(int amount) {
        try {
            permits.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (amount <= balance) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
        }
        permits.release();
        return balance;
    }
}

class AccountHolder implements Runnable {
    private String name;
    private CheckingAccountTwo account;

    AccountHolder(String name, CheckingAccountTwo account) {
        this.name = name;
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " tries to withdaw $10, balance: "
                    + account.withdraw(10));
        }
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        CheckingAccountTwo account = new CheckingAccountTwo(100);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new AccountHolder("Wife", account));
        executorService.submit(new AccountHolder("Husband", account));
        executorService.shutdown();
    }
}
