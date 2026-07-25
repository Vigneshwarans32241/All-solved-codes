import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int D = sc.nextInt();
        String s = sc.next();
        char[] arr = s.toCharArray();
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (arr[i] == 'G') continue;
            boolean watching = false;
            for (int j = Math.max(0, i - D); j <= Math.min(M - 1, i + D); j++) {
                if (arr[j] == 'G') {
                    watching = true;
                    break;
                }
            }
            if (!watching) count++;
        }
        System.out.println(count);
    }
}
