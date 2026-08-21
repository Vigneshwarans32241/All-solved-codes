import java.util.*;
class Static_Range_Sum_Queries {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long Q = sc.nextLong();
        long[] sum = new long[N+1];
        for(int i = 0;i<N;i++) sum[i+1] = sum[i]+sc.nextLong();
        for(int i = 0;i<Q;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(sum[r]-sum[l-1]);
        }
    }
}