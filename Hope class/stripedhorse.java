import java.util.*;
public class stripedhorse {
    public static void printarr(int[] arr){
        for(int i = 0;i<arr.length;i++) System.out.print(arr[i]+" ");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),W = sc.nextInt();
        int[] arr = new int[2*W];
        for(int i = 0;i<N;i++){
            arr[i%(W+W)] += sc.nextInt();
        }
        printarr(arr);
    }
}
