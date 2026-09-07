class Solution {
    public int distinctSubseqII(String s) {
        int N = s.length();
        long[] dp = new long[N+1];
        dp[0] = 1;
        long[] last = new long[26];
        for(int i = 1;i<=N;i++){
            char c = s.charAt(i-1);
            dp[i] = (2 * dp[i - 1]) % 1000000007;
            if(last[c-'a']!=0) dp[i] = (dp[i] - last[c - 'a'] + 1000000007) % 1000000007;
            last[c-'a'] = dp[i-1];
            
        }
        return (int)((dp[N] - 1 + 1000000007) % 1000000007);
    }
}
