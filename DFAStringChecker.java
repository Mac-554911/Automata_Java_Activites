package Java.Automata.DFAStringChecker;
import java.util.*;

public class DFAStringChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a binary string: ");
        String bnryStr = sc.nextLine();

        boolean bool = isAccepted(bnryStr);

        if (bool) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected");
        }

        sc.close();
    }

    public static boolean isAccepted(String bnryStr) {
        int currentState = 0;

        for (int i = 0; i < bnryStr.length(); i++) {
            char currentChar = bnryStr.charAt(i);

            switch (currentState) {
                case 0 -> {
                switch (currentChar) {
                    case '0' -> currentState = 1;
                    case '1' -> currentState = 0;
                    default -> {
                        System.out.println("Invalid input. Only 0 and 1 allowed.");
                        return false;
                    }
                }
                }
                case 1 -> {
                switch (currentChar) {
                    case '0' -> currentState = 1;
                    case '1' -> currentState = 2;
                    default -> {
                        System.out.println("Invalid input. Only 0 and 1 allowed.");
                        return false;
                    }
                }
                }
                case 2 -> {
                switch (currentChar) {
                    case '0' -> currentState = 1;
                    case '1' -> currentState = 0;
                    default -> {
                        System.out.println("Invalid input. Only 0 and 1 allowed.");
                        return false;
                    }
                }
                }
                default -> {
                }
            }
        }

        return currentState == 2;
    }
}
