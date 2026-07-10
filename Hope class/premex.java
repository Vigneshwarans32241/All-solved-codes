import java.util.*;
public class premex {
    public static int mex(Scanner sc){
        int N = sc.nextInt(),total = 0;
        int[] arr = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0 ;i<N;i++){
            int curr,max = arr[0];
            for(int j = 0;j<=i;j++){
                curr = arr[j];
                max = Math.max(curr,max);
            }
            total+=max;
        }
        return total;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0;i<t;i++){
            System.out.println(mex(sc));
        }
    }
}
