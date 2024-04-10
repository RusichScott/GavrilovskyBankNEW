package bank;

import java.util.Scanner;

public class ATM {
    public void start(){
        showStartATMInfo();

        System.out.println(Bank.getAccounts().get(0).getClient().getCard().getCARD_NUMBER());
        System.out.println(Bank.getAccounts().get(0).getClient().getCard().getPinCode());
        checkUserChoice();
    }

    private void checkUserChoice() {
        String choice = getScannerData();

        switch (choice){
            case "1" -> askCardData();
            case "2" -> createPersonalAccount();
            default -> showChoiceError();
        }
    }

    private void askCardData() {
        System.out.println("Вставьте карту");
        String cardNumber = getScannerData();
        checkPinCode(cardNumber);
        System.out.println("Добро пожаловать, " + Bank.getAccounts().get(0).getClient().getName() + Bank.getAccounts().get(0).getClient().getSurname());
        System.out.println("Что желаете? \n1-Посмотреть баланс \n2-Пополнить баланс \n3-Изменить пин-код");
        String choice = getScannerData();
        switch (choice){
            case "1" -> checkBalance();
            case "2" -> topUpBalance();
//            case "3" -> changePinCode();
        }
    }

    private int checkBalance() {
        int balance = Card.rnd(0, 1_000_000);
        System.out.println("Ваш баланс: " + balance + "рублей");
        return balance;
    }

    private void topUpBalance() {
        System.out.println(checkBalance());
        System.out.println("На сколько желаете пополнить?");
        int money = Integer.parseInt(getScannerData());
        int newBal = checkBalance() + money;
        System.out.println("Пополнение успешно! \nВаш баланс: " + newBal + "рублей");
    }

//    private void changePinCode() {
//        String newPin = Card.getPinCode();
//    }

    private void checkPinCode(String cardNumber) {
        for(int i=0; i < Bank.getAccounts().size(); i++){
            if (cardNumber.equals(Bank.getAccounts().get(i).getClient().getCard().getCARD_NUMBER())){
                System.out.println("Введите пин-код:");
                String pinCode = getScannerData();
                if(pinCode.equals(Bank.getAccounts().get(i).getClient().getCard().getPinCode())){
                    System.out.println("Добро пожаловать в банкомат!");
                }else{
                    showChoiceError();
                }
            }else{
                showChoiceError();
            }
        }
    }

    private void createPersonalAccount() {
        System.out.println("Здравствуйте, " + Bank.getAccounts().get(0).getClient().getName());
        System.out.println("Ваш лицевой счёт: " + Bank.getAccounts().get(0).getClient().getCard().getCARD_NUMBER());
    }

    private void showChoiceError() {
        System.out.println("Error. Please try again");
        checkUserChoice();
    }

    private void showATMFunctionality() {
        System.out.println("1 - Вставить карту");
        System.out.println("2 - создать лицевой счёт");
    }

    private String getScannerData() {;
        return new Scanner(System.in).nextLine();
    }

    private void showStartATMInfo() {
        System.out.println("Приветсвуем, выберите действие: ");
        System.out.println("1 - Вставить карту");
        System.out.println("2 - создать лицевой счёт");

    }
}
