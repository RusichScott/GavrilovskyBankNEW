package data;

import bank.Card;

public class
Client {
    private String name;
    private String surname;
    private Card card;

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
        card = new Card();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Card getCard() {
        return card;
    }
}
