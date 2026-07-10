    import java.util.*;
    public class prefixsum {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int[] arr = new int[N];
            int[] presum = new int[N];
            for(int i = 0;i<N;i++){
                arr[i] = sc.nextInt();
            }
            presum[0] = arr[0];
            for(int i = 1;i<N;i++){
                presum[i] = presum[i-1]+arr[i];
            }
            for(int i = 0;i<N;i++){
                System.out.print(presum[i]+" ");
            }
            int start,end;
            start = sc.nextInt();
            end = sc.nextInt();
            if(start==1) System.out.print(presum[end-1]);
            else System.out.print(presum[end-1]-presum[start-2]);
        }
    }
