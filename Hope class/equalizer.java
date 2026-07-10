import java.util.*;

public class equalizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int sum = 0;
            for (int nums = 0; nums < n; nums++) {
                sum += sc.nextInt();
            }
            if (sum % 2 == 1 || (n * k) % 2 == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }
}