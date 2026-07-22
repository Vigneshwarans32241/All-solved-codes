import java.util.*;
public class D_Many_Repunit_Sum {
    static int lowerbound(int[] arr,int target){
        int left = 0,right=arr.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if(arr[mid]<target) left = mid+1;
            else right = mid;
        }
        return left;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0;i<N;i++) A[i] = sc.nextInt();
        Arrays.sort(A);
        int maxA = A[N-1];
        StringBuilder ans = new StringBuilder();
        long carry = 0;
        for(int pos = 1;pos<=maxA;pos++){
            int index = lowerbound(A,pos);
            int count = N-index;
            long current = count+carry;
            ans.append(current%10);
            carry = current/10;
        }
        while(carry>0){
            ans.append(carry%10);
            carry/=10;
        }
        System.out.println(ans.reverse());
    }
}
