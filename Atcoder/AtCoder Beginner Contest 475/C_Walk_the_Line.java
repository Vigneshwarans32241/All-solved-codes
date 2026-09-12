import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int S=sc.nextInt()-1;
        long L=sc.nextLong();
        long[] prefix=new long[N];
        for(int i=1;i<N;i++){
            prefix[i]=prefix[i-1]+sc.nextLong();
        }
        int ans=1;
        for(int l=0;l<=S;l++){
            long left=prefix[S]-prefix[l];
            for(int r=S;r<N;r++){
                long right=prefix[r]-prefix[S];
                long cost=Math.min(2*left+right,left+2*right);
                if(cost<=L){
                    ans=Math.max(ans,r-l+1);
                }
            }
        }
        System.out.println(ans);
    }
}
