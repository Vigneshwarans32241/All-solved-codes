class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        for(int i = 1;i<=n;i++){
            int x = 1;
            for(x = 1;x*x<=i;x++){
                int sq = x*x;
                if(dp[i-sq]==false){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
