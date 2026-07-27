import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
 
            long minOdd = Long.MAX_VALUE;
            long maxEven = Long.MIN_VALUE;
 
            for (int i = 1; i <= n; i++) {
                long w = sc.nextLong();
 
                if (i % 2 == 1) {
                    minOdd = Math.min(minOdd, w);
                } else {
                    maxEven = Math.max(maxEven, w);
                }
            }
 
            if (n % 2 == 1) {
                System.out.println("NO");
            } else if (minOdd - maxEven >= 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
 
        sc.close();
    }
}
