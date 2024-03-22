package bank;

import java.util.Scanner;

public class ATM {
    public void start(){
        showStartATMInfo();

        checkUserChoice();
    }

    private void checkUserChoice() {
        String choice = getScannerData();

        switch (choice){
            case "1" -> askCardData();
            case "2" -> askAdminData();
            default -> showChoiceError();
        }
    }

    private void askCardData() {
        System.out.println("Вставьте карту");
        String cardNumber = getScannerData();
        checkPinCode(cardNumber);
    }

    private void checkPinCode(String cardNumber) {
        for(int i=0; i < Bank.getAccounts().size(); i++){
            if (cardNumber.equals(Bank.getAccounts().get(i).getClient().getCard().getCARD_NUMBER())){
                System.out.println("Введите пин-код:");
                String pinCode = getScannerData();
                if(pinCode.equals(Bank.getAccounts().get(i).getClient().getCard().getPinCode())){
                    System.out.println("Добро пожаловать в банкомат!");
                }
            }
        }
    }

    private void askAdminData() {
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
