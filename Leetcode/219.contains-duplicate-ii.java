class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> seen = new HashSet<>();
        int N = nums.length;
        for(int i = 0;i<N;i++){
            if(!seen.add(nums[i])) return true;
            if(i>=k) seen.remove(nums[i-k]);
        }
        return false;
    }
}
