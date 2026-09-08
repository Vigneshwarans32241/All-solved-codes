import java.util.*;
class A_Monocarps_Contest{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) solve(sc);
    }
    private static void solve(Scanner sc){
        int N = sc.nextInt();
        int[] arr = new int[N];
        int zeros = 0;
        for(int i = 0;i<N;i++) arr[i] = sc.nextInt();
        for(int i = 0;i<N;i++) if(arr[i]==0) zeros++;
        if(zeros<2) System.out.println(-1);
        else if(arr[0]==0 && arr[N-1]==0) System.out.println(0);
        else if(arr[0]==1 && arr[N-1]==1) System.out.println(2);
        else System.out.println(1);
    }
}