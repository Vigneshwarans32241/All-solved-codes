class Solution {
    public int maxRotateFunction(int[] nums) {
        long f0 = 0;
        long sum = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++) sum+=nums[i];
        for(int i = 0;i<n;i++) f0 += (long) nums[i]*i;
        long current = f0;
        long max = f0;
        for(int i = 1;i<n;i++){
            current = current +sum- (long) n*(nums[n-i]);
            max = Math.max(max,current);
        }
        return (int) max;
    }
}
