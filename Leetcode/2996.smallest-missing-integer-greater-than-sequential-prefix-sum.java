class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]+1) break;
            sum+=nums[i];
        }
        int candidate = sum;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++) set.add(nums[i]);
        while(set.contains(candidate)) candidate++;
        return candidate;
    }
}
