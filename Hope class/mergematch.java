import java.util.*;
public class mergematch{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] arr1 = new int[M];
        int[] arr2 = new int[N];
        for(int i=0;i<M;i++) arr1[i] = sc.nextInt();
        for(int i=0;i<N;i++) arr2[i] = sc.nextInt();
        if(M<N+N){
            System.out.println("NO");
            return;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Collections.reverse(Arrays.asList(arr2));
        int i = M-1;
        for(int val : arr2){
            if(i>=0 && arr1[i]<val){
                System.out.println("NO");
                return;
            }
            i--;
        }
        Collections.reverse(Arrays.asList(arr1));
        Collections.reverse(Arrays.asList(arr2));
        i = M-1;
        for(int val : arr2){
            if(i>=0 && arr1[i]>val){
                System.out.println("NO");
                return;
            }
            i--;
        }
        System.out.println("YES");
    }           
}