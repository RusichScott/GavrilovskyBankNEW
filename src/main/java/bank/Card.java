package bank;

public class Card {
    private final String CARD_NUMBER;


    private String pinCode;

    public Card() {
        CARD_NUMBER = generateNumbers(16);
        pinCode = generateNumbers(4);
    }

    private String generateNumbers(int length) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < length; i++){
            builder.append(rnd(0,9));
        }
        return builder.toString();
    }


    public String getCARD_NUMBER() {
        return CARD_NUMBER;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }


    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}

