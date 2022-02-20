import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int result = 0;

        while (check(s)) {
            if ("0".equals(s)) {
                break;
            }
            s = "0".repeat(s.length() - String.valueOf(Integer.parseInt(s) + 1).length()) + (Integer.parseInt(s) + 1);
            result++;
        }

        if (!"0".equals(s)) {
            System.out.println(result);
        }
    }

    public static boolean check(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            String s1 = String.valueOf(s.charAt(i));
            String s2 = String.valueOf(s.charAt(s.length() - i - 1));
            if (s1.equals(s2) == false) {
                return true;
            }
        }

        return false;
    }
}
