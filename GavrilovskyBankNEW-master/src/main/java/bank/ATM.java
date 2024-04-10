package bank;

import data.BankAccount;
import data.BankData;

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
            case "3" -> exitATM();
            default -> showChoiceError();
        }
        askCardAction();
    }

    private void exitATM() {
        System.out.println("Вы вышли из банкомата.");
    }

    private void askCardAction(){
        System.out.println("Добро пожаловать, " + Bank.getAccounts().get(0).getClient().getName() + Bank.getAccounts().get(0).getClient().getSurname());
        System.out.println("Что желаете? \n1-Посмотреть баланс \n2-Пополнить баланс \n3-Изменить пин-код");
        String choice = getScannerData();
        switch (choice){
            case "1" -> ATMBalance();
            case "2" -> topUpBalance();
            case "3" -> changePinCode();
            default -> showChoiceError();
        }
        askCardAction();
    }

    private void changePinCode() {
        System.out.println("Введите новый пин-код");
        String newPinCode = getScannerData();
        Bank.getAccounts().get(0).getClient().getCard().setPinCode(newPinCode);
    }

    private void askCardData() {
        System.out.println("Вставьте карту");
        String cardNumber = getScannerData();
        checkPinCode(cardNumber);
    }

    private void ATMBalance(){
        System.out.println("Ваш баланс: " + BankData.getAccounts().get(0).getBalance() + " рублей");
    }
    private void topUpBalance() {
        System.out.println("Ваш баланс " + BankData.getAccounts().get(0).getBalance());
        System.out.println("На сколько желаете пополнить?");
        int money = Integer.parseInt(getScannerData());
        int newBal = BankData.getAccounts().get(0).getBalance() + money;
        System.out.println("Пополнение успешно! \nВаш баланс: " + newBal + " рублей");
    }


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
