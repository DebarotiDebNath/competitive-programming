import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 1; i <=n; i++) {
            String word = scanner.next();
            if (word.length() <= 10) System.out.println(word);
            else {
                String abbreviation = "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
                System.out.println(abbreviation);
            }
        }
    }
}