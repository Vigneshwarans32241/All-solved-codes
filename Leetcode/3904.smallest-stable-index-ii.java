class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int N = nums.length;
        int[] premax = new int[N];
        int[] sufmin = new int[N];
        premax[0] = nums[0];
        for(int i = 1;i<N;i++) premax[i] = Math.max(nums[i],premax[i-1]);
        sufmin[N-1] = nums[N-1];
        for(int i = N-2;i>=0;i--) sufmin[i] = Math.min(nums[i],sufmin[i+1]);
        for(int i = 0;i<N;i++){
            int ans = premax[i]-sufmin[i];
            if(ans<=k) return i;
        }
        return -1;
    }
}
