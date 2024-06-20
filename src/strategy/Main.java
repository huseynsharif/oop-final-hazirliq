package strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static final Order order = new Order();
    private static final Scanner scanner = new Scanner(System.in);

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args) {

        while (!order.isClosed()){
            int cost;
            String continueChoice;

            do{
                System.out.print("Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");
                int choice = Integer.parseInt(scanner.nextLine());
                cost = priceOnProducts.get(choice);
                System.out.print("Count: ");
                int count = Integer.parseInt(scanner.nextLine());
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = scanner.nextLine();
            }while (continueChoice.equalsIgnoreCase("Y"));

            System.out.println("""
                    Please, select a payment method:
                    1 - PalPay
                    2 - Credit Card""");

            String paymentMethod = scanner.nextLine();
            PayStrategy strategy;
            if (paymentMethod.equals("1")){
                strategy = new PayByPayPal();
            }
            else {
                strategy = new PayByCreditCard();
            }

            order.processOrder(strategy);
            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = scanner.nextLine();
            if (proceed.equalsIgnoreCase("P")) {
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();

            }
        }

    }

}
