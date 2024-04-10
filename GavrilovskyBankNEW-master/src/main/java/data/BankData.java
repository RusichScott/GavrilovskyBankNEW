package data;

import java.util.ArrayList;
import java.util.List;

public class BankData {
    private static List<BankAccount> accounts;

    public static List<BankAccount> getAccounts() {
        return accounts;
    }

    static {
        Client user = new Client("Vasya", "Pupkin");
        BankAccount account = new BankAccount(user);

        accounts = new ArrayList<>();
        accounts.add(account);
    }
}
