class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int N = nums.length;
        if(nums.length==k){
            int max = Integer.MIN_VALUE;
            for(int n : nums) max = Math.max(max,n);
            return max;
        }
        for(int i = 0;i<=N-k;i++){
            for(int j = i;j<i+k;j++){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int n : map.keySet()){
            if(map.get(n)==1){
                max = Math.max(max,n);
            }
        }

        if (max==Integer.MIN_VALUE) return -1;
        return max;
    }
}
