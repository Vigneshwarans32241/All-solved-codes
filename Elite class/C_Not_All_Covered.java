import java.util.*;
import java.util.stream.IntStream;
public class C_Not_All_Covered {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        // int[] arr = new int[N];
        // for(int t = 0;t<M;t++){
        //     int L = sc.nextInt();
        //     int R = sc.nextInt();
        //     for(int w = L-1;w<=R-1;w++){
        //         arr[w]+=1;
        //     }
        // }
        // // for(int i = 0;i<N;i++){
        // //     System.out.print(arr[i]+" ");
        // // }
        // int count = 0;
        // while(!IntStream.of(arr).anyMatch(x->x==0)){
        //     Arrays.setAll(arr,i -> arr[i]-1);
        //     count++;
        // }
        // System.out.println(count);
        int[] diff = new int[N+1];
        for(int i = 0;i<M;i++){
            int L = sc.nextInt();
            int R = sc.nextInt();
            diff[L-1]++;
            if(R<N) diff[R]--;u
        }
        int curr = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<N;i++){
            curr+=diff[i];
            ans = Math.min(ans,curr);
        }
        System.out.println(ans);
    }
}
