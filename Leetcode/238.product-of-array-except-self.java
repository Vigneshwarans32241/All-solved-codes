class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = nums[0];
        suffix[N-1] = nums[N-1];
        for(int i = 1;i<N;i++) prefix[i] = prefix[i-1]*nums[i];
        for(int i = N-2;i>=0;i--) suffix[i] = suffix[i+1]*nums[i];
        int[] ans = new int[N];
        ans[0] = suffix[1];
        ans[N-1] = prefix[N-2];
        for(int i = 1;i<N-1;i++) ans[i] = prefix[i-1]*suffix[i+1];
        return ans;
    }
}
