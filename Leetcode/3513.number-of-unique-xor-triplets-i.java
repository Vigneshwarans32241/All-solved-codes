class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if(nums.length>=3){
            String binary = Integer.toBinaryString(nums.length);
            int msb = binary.length()-1;
            int pow = 1 << (msb+1);
            return pow;
        }
        else if(nums.length==1) return 1;
        else if(nums.length==2) return 2;
        return 0;
    }
}