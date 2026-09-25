class Solution {
    public int maximumJumps(int[] nums, int target) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i = 0;i<N;i++){
            for(int j = 0;j<i;j++){
                if(dp[j]!=-1){
                    if((0-target)<=nums[j]-nums[i] && nums[j]-nums[i]<=target){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[N-1];
    }
}
