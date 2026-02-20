import java.util.Scanner;

/**
 * Tower of Hanoi recursion:
 * Move (n-1) source->aux, move n source->dest, move (n-1) aux->dest.
 */
public class HanoiTower {
    public static void hanoi(int n, char source, char aux, char dest) {
        if (n == 1) {
            System.out.println(source + " -> " + dest);
            return;
        }
        hanoi(n - 1, source, dest, aux);
        System.out.println(source + " -> " + dest);
        hanoi(n - 1, aux, source, dest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();
        hanoi(n, 'A', 'B', 'C');
    }
}
