package data;

import bank.Card;

public class BankAccount {

    private int balance;

    private String personalAccount;

    private Client client;

    public BankAccount(Client client) {
        this.client = client;
        personalAccount = client.getCard().getCARD_NUMBER();
        balance = checkBalance();
    }

    public String getPersonalAccount() {
        return personalAccount;
    }

    public Client getClient() {
        return client;
    }


    private int checkBalance() {
        return Card.rnd(0, 1_000_000);
    }
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
