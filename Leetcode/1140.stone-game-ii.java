class Solution {
    public int stoneGameII(int[] piles) {
        int N = piles.length;
        int[][] dp = new int[N+1][N+1];
        int[] suffixsum = new int[N];
        suffixsum[N-1] = piles[N-1];
        for(int i = N-2;i>=0;i--){
            suffixsum[i] += suffixsum[i+1]+piles[i];
        }
        for(int i = N-1;i>=0;i--){
            for(int M = 1;M<=N;M++){
                for(int X = 1;X<=Math.min(2*M,N-i);X++){
                    int newM = Math.max(M,X);
                    int current = suffixsum[i]-dp[i+X][newM];
                    dp[i][M] = Math.max(dp[i][M],current);
                }
            }
        }
        return dp[0][1];
    }
}
