class Solution {
    public int reverseDegree(String s) {
        int N = s.length();
        int ans = 0;
        for(int i = 0;i<N;i++){
            int n = 26 - (s.charAt(i)-'a');
            ans += (n*(i+1));
        }
        return ans;
    }
}
