import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0) solve(sc);
    }
    private static void solve(Scanner sc){
        int N=sc.nextInt();
        int[] A=new int[N+1];
        int[] B=new int[N+1];
        int[] diff=new int[N+1];
        int base=0;
        int ans=Integer.MAX_VALUE;
        int minval=Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            A[i]=sc.nextInt();
            B[i]=sc.nextInt();
            base+=A[i];
            diff[i]=A[i]-B[i];
            minval=Math.min(minval,A[i]);
        }
        Integer[] idx=new Integer[N+1];
        for(int i=1;i<=N;i++) idx[i]=i;
        Arrays.sort(idx,1,N+1,(i,j)->Integer.compare(diff[j],diff[i]));
        for(int i=1;i<=N;i++){
            if(N-i>=i){
                base=Math.min(base,base-A[idx[i]]+B[idx[i]]);
                ans=Math.min(ans,base);
            }else{
                base=Math.min(base,base-A[idx[i]]+B[idx[i]]);
                ans=Math.min(ans,base+(minval*(i-(N-i))));
            }
        }
        System.out.println(ans);
    }
}
