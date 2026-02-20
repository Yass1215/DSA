import java.util.Scanner;

/**
 * Rabbit Problem -> Fibonacci recursion.
 **/
public class RabbitProblem {
    public static long fibonacciRabbits(int month) {
        if (month <= 1) return month;
        return fibonacciRabbits(month - 1) + fibonacciRabbits(month - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month n (e.g., 12 for 1 year): ");
        int n = sc.nextInt();
        System.out.println("Rabbit pairs after month " + n + " = " + fibonacciRabbits(n));
    }
}
