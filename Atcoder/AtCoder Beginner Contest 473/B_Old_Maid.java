import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] count = new int[101];
        for (int i = 0; i < n; i++) count[sc.nextInt()]++;
        int sum = 0;
        for (int i = 1; i <= 100; i++) if (count[i] % 2 == 1) sum += i;
        System.out.println(sum);
    }
}
