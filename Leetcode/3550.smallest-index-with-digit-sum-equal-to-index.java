class Solution {
    private static int sod(int num){
        int ans = 0;
        while(num>0){
            ans+=num%10;
            num/=10;
        }
        return ans;
    }
    public int smallestIndex(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            int digits = sod(nums[i]);
            if(digits==i) return i;
        }
        return -1;
    }
}
