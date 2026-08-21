class Solution {
    public int[] resultArray(int[] nums) {
        int N = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i = 2;i<N;i++){
            int last1 = arr1.getLast();
            int last2 = arr2.getLast();
            if(last1>last2) arr1.add(nums[i]);
            else arr2.add(nums[i]);
        }
        int[] ans = new int[N];
        for(int i = 0;i<arr1.size();i++) ans[i] = arr1.get(i);
        for(int i = 0;i<arr2.size();i++) ans[i+arr1.size()] = arr2.get(i);
        return ans;
    }
}
