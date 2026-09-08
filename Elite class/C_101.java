import java.util.*;
class C_101{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0;i<N;i++) arr[i] = sc.nextInt();
        int left = 0,right = N-1;
        while(left<N && arr[left]==0) left++;
        while(right>=0 && arr[right]==0) right--;
        if(left<=right){
            for(int i = left+1;i<right;i++){
                if(arr[i]==-1) arr[i] = 0;
            }
            arr[left] = 1;
            arr[right] = 1;
        }
        for(int i = 0;i<N;i++) System.out.print(arr[i]+" ");
        System.out.println();
    }
}