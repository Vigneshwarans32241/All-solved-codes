class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int N = nums.length;
        int[] ans = new int[N];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<N;i++){
            max = Math.max(max,nums[i]);
            int min = Integer.MAX_VALUE;
            for(int j = i;j<N;j++) min = Math.min(nums[j],min);
            ans[i] = max-min;
            System.out.println(max+"-"+min);
        }
        for(int i = 0;i<N;i++){
            if(ans[i]<=k) return i;
            System.out.println(ans[i]);
        } 
        return -1;
    }
}
