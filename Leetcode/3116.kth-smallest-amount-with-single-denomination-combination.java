class Solution {
    private long gcd(long a,long b){
        if(b==0) return a;
        else if(a==0) return b;
        else return gcd(b,a%b);
    }
    private long lcm(long a,long b){
        return (a/gcd(a,b))*b;
    }
    private long count(long x,int[] coins){
        long count = 0;
        for(int mask = 1;mask<(1<<coins.length);mask++){
            long currlcm = 1;
            int bits = 0;
            for(int i = 0;i<coins.length;i++){
                if((mask & (1<<i))!=0) {
                    currlcm = lcm(currlcm,coins[i]);
                    bits++;
                }
            }
            if(bits%2==1) count+= x/currlcm;
            else count-=x/currlcm;
        }
        return count;
    }
    public long findKthSmallest(int[] coins, int k) {
        long mincoin = coins[0];
        for(int coin : coins) mincoin = Math.min(mincoin,coin);
        long low = 1;
        long high = mincoin * (long) k;
        while(low<high){
            long mid = low+(high-low)/2;
            long count = count(mid,coins);
            if(count>=k) high = mid;
            else low = mid+1;
        }
        return low;
    }
}
