package Java.Automata.NFAStringChecker;
import java.util.*;

public class NFAStringChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String bnryStr = sc.nextLine();

        boolean bool = checkNFA(bnryStr);

        if (bool) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected");
        }

        sc.close();
    }

    public static boolean checkNFA(String bnryStr) {
        String state = "q0";

        for (int i = 0; i < bnryStr.length(); i++) {
            char c = bnryStr.charAt(i);

            if (state.equals("q0")) {
                if (c == 'a') {
                    state = "q1";
                } 
            } else if (state.equals("q1")) {
                state = switch (c) {
                    case 'b' -> "q2";
                    case 'a' -> "q1";
                    default -> "q0";
                };
            } 
        }

        return state.equals("q2");
    }
}
