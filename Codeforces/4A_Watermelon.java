import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int weight = scanner.nextInt();

        if (weight % 2 == 0 && weight > 2) System.out.println("YES");
        else System.out.println("NO");
    }
}