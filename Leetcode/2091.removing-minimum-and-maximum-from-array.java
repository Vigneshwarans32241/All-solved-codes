class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = 0, max = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[min]) min = i;
            if(nums[i] > nums[max]) max = i;
        }
        int left = Math.min(min, max) + 1;
        int right = n - Math.max(min, max);
        int bothLeft = Math.max(min, max) + 1;
        int bothRight = n - Math.min(min, max);
        return Math.min(Math.min(bothLeft, bothRight), left + right);
    }
}
