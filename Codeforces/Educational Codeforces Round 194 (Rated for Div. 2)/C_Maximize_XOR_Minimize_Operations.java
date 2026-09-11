import java.util.*;
class C_Maximize_XOR_Minimize_Operations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        long x = sc.nextLong();
        long y = sc.nextLong();
        long sum = x + y;
        long cur = 0;
        for (int bit = 30; bit >= 0; bit--) {
            long mask = 1L << bit;
            if ((sum & mask) != 0 && cur + mask <= x) cur += mask;
        }
        long operations = x - cur;
        long maxXor = sum;
        System.out.println(maxXor + " " + operations);
    }
}
