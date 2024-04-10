package data;

public class BankAccount {
    private String personalAccount;

    private Client client;

    public BankAccount(Client client) {
        this.client = client;
        personalAccount = client.getCard().getCARD_NUMBER();
    }

    public String getPersonalAccount() {
        return personalAccount;
    }

    public Client getClient() {
        return client;
    }
}
