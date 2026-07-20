import java.util.*;
public class D_Two_digit_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        String a = sc.next();
        String b = sc.next();
        int[] moda = summodulo(a);
        int[] modb = summodulo(b);
        // for(int i = 0;i<moda.length;i++){
        //     System.out.print(moda[i]);
        // }
        // System.out.println();
        // for(int i = 0;i<modb.length;i++){
        //     System.out.print(modb[i]);
        // }
        if(moda[moda.length-1]!=modb[modb.length-1]){
            System.out.println(-1);
            return;
        }
        int[][] dp = new int[moda.length+1][modb.length+1];
        for(int i = 1;i<=moda.length;i++){
            for(int j = 1;j<=modb.length;j++){
                if(moda[i-1]==modb[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }   
        System.out.println(dp[moda.length][modb.length]);

    }
    private static int[] summodulo(String S){
        // int num = Integer.parseInt(S);
        int[] mod = new int[S.length()];
        int sum = 0;
        for(int i = 0;i<S.length();i++){
            sum += S.charAt(i)-'0';
            mod[i] = sum%10;
        }
        return mod;
    }
}