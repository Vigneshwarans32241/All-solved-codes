import java.util.*;
public class arraygame {
    public static String alicebob(Scanner sc){
        int n = sc.nextInt(),zeros = 0;
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = sc.nextInt();
            if(nums[i]==0) zeros++;
        }
        if(nums[0]==0 && nums[n-1]==0 && zeros%2==0) return "Bob";
        else return "Alice";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0;i<t;i++){
            System.out.print(alicebob(sc));
        }
        sc.close();
    }
}
