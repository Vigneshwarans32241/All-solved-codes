class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] prefixmul = new int[N];
        int[] suffixmul = new int[N];
        int sq;
        prefixmul[0] = nums[0];
        suffixmul[N-1] = nums[N-1];
        for(int i = 1;i<N;i++){
            prefixmul[i] = prefixmul[i-1]*nums[i];
            // System.out.println(prefixmul[i]);
        }
        for(int i =N-2;i>=0;i--){
            suffixmul[i] = suffixmul[i+1]*nums[i];
            // System.out.println(suffixmul[i]);
        }
        int[] ans = new int[N];
        ans[0] = suffixmul[1];
        ans[N-1] = prefixmul[N-2];
        for(int i = 1;i<N-1;i++){
            ans[i] = prefixmul[i-1]*suffixmul[i+1];
        }
        return ans;
    }
}
