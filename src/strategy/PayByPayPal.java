package strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PayByPayPal implements PayStrategy {

    private static final Map<String, String> DB = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    private String email;
    private String password;
    private boolean signedIn;

    static {
        DB.put("huseyn@gmail.com", "123");
        DB.put("andrey@gmail.com", "456");
    }


    @Override
    public void collectPaymentsDetails() {
        while (!signedIn){
            System.out.println("Email:");
            email = scanner.nextLine();
            System.out.println("Password:");
            password = scanner.nextLine();

            if (verify()){
                signedIn = true;
                System.out.println("Successfully signed in.");
            }
            else {
                System.out.println("Email or password is incorrect.");
            }
        }

    }

    private boolean verify() {
        return setSignedIn(password.equals(DB.get(email)));
    }

    @Override
    public boolean pay(int amount) {

        if (signedIn){
            System.out.println("Paying " + amount + " using PayPal");
            return true;
        }
        else {
            return false;
        }

    }

    public boolean setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
        return signedIn;
    }
}
