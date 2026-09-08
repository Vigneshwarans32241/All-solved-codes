import java.util.*;
class B_Monocarp_and_Projects{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) solve(sc);
    }
    private static void solve(Scanner sc) {
        long x = sc.nextLong();
        long y = sc.nextLong();
        long k = sc.nextLong();
        long d = y - x;
        long ans = 0;
        long start = Math.max(0, d - x + 1);
        long limit = Math.min(k, start);
        for (long i = 0; i < limit; i++) ans += d % (x + i);
        if (start < k) ans += (k - start) * d;
        System.out.println(ans);
    }
}