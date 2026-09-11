class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = Long.MIN_VALUE;
        long prefix = 0;
        Map<Integer, Long> numtominprefix = new HashMap<>();
        for(int num : nums){
            if(!numtominprefix.containsKey(num)|| numtominprefix.get(num)>prefix) numtominprefix.put(num,prefix);
            prefix+=num;
            if(numtominprefix.containsKey(num+k)) ans = Math.max(ans,prefix-numtominprefix.get(num+k));
            if(numtominprefix.containsKey(num-k)) ans = Math.max(ans,prefix-numtominprefix.get(num-k));
        }
        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}
