class Solution {
    public long countCommas(long n) {
        if(n<999) return 0;
        long start = 1000;
        int commas = 1;
        long ans = 0;
        while(start<=n){
            long end = Math.min(n,start*1000-1);
            long vals = end-start+1;
            ans += vals*commas;
            start*=1000;
            commas++;
        }
        return ans;
    }
}
