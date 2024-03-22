package bank;

import data.BankAccount;
import data.Client;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static List<BankAccount> accounts;

    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "0000";

    static {
        accounts = new ArrayList<>();

        Client client = new Client("Dima", "Gavrilovskiy");
        BankAccount bankAccount= new BankAccount(client);

        accounts.add(bankAccount);
    }

    public static List<BankAccount> getAccounts() {
        return accounts;
    }
}
