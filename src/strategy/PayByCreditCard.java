package strategy;

import java.util.Scanner;

public class PayByCreditCard implements PayStrategy {

    private final Scanner scanner = new Scanner(System.in);
    private CreditCard card;
    
    @Override
    public void collectPaymentsDetails() {
        System.out.print("Enter the card number: ");
        String number = scanner.nextLine();
        System.out.print("Enter the card expiration date 'mm/yy': ");
        String date = scanner.nextLine();
        System.out.print("Enter the CVV code: ");
        String cvv = scanner.nextLine();
        card = new CreditCard(number, date, cvv);
    }

    @Override
    public boolean pay(int amount) {

        if (cardIsPresent()){
            System.out.println("Paying " + amount + " using credit card: " + card.getNumber());
            card.decreaseAmount(amount);
            return true;
        }else {
            return false;
        }
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}
