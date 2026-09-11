class Solution {
    public int pivotIndex(int[] nums) {
        int[] sumleft = new int[nums.length+1];
        int[] sumright = new int[nums.length+1];
        for(int i = 0;i<nums.length;i++) sumleft[i+1] = sumleft[i]+nums[i];
        for(int i = nums.length;i>0;i--) sumright[i-1] = sumright[i]+nums[i-1];
        for(int i = 0;i<nums.length;i++) if(sumleft[i]==sumright[i+1]) return i;
        return -1;
    }
}
