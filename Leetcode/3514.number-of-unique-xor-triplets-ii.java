class Solution {
    public int uniqueXorTriplets(int[] nums) {
        // String binary = Integer.toBinaryString(nums.length);
        // int msb = binary.length()-1;
        // int pow = 1 << (msb+1);
        // if(nums.length>=3) return pow;
        // // else return nums.length;
        // Arrays.sort()
        // Set<Integer> set = new HashSet<>();
        // for(int i = 0;i<nums.length;i++){
        //     int xor = 0;
        //     int ixor = nums[i];
        //     for(int j = i;j<nums.length;j++){
        //         int jxor = ixor;
        //         jxor^=nums[j];
        //         for(int k = i;k<nums.length;k++){
        //             System.out.println(jxor^nums[k]);
        //             set.add(jxor^nums[k]);
        //         }
        //     }
        // }
        // for(int i = 0;i+2<nums.length;i++){
        //     int left = i+1;
        //     int right = nums.length-1;
        //     while(left<right){
        //         int xor = Math.max(nums[i],Math.max(nums[left],nums[right]));
        //         set.add(xor);
        //         while(nums[left]<nums[i] && nums[left]>nums[right]) left++;
        //     }
        // }
        // System.out.println(set);
        // return set.size();
        int n = nums.length;
        if(n==1) return 1;
        Set<Integer> pairs = new HashSet<>();
        BitSet triplets = new BitSet();
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                pairs.add(nums[i]^nums[j]);
            }
        }
        for(int pair : pairs){
            for(int num : nums){
                triplets.set(pair^num);
            }
        }
        return triplets.cardinality();
    }
}
