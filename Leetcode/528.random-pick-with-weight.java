class Solution {
    private int[] prefix;
    private Random rand = new Random();
    public Solution(int[] w) {
        prefix = w;
        for(int i = 1;i<w.length;i++) prefix[i]+=prefix[i-1];
    }
    
    public int pickIndex() {
        int target = rand.nextInt(prefix[prefix.length-1]);
        int l = 0;
        int r = prefix.length;
        while(l<r){
            int m = (l+r)/2;
            if(prefix[m]>target) r = m;
            else l = m+1;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
