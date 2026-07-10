import java.util.*;
public class swap {
    public static void printarr(int[] arr){
        for(int i = 0;i<arr.length;i++) System.out.print(arr[i]+" ");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++) arr[i] = sc.nextInt();
        int left = 0,right = n-1;
        while(left<right){
            if(arr[left]%2==0) left++;
            else if(arr[right]%2==0) right--;
            else{
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;right--;
            }
        }
        printarr(arr);
    }
}
