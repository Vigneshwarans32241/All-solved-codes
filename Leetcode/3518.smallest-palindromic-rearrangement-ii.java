class Solution {
    static final long LIMIT = 1000001;
    long[][] C = new long[5005][27];
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        int[] half = new int[26];
        String mid = "";
        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            if ((freq[i] & 1) == 1)
                mid = "" + (char) ('a' + i);
        }
        buildComb(s.length() / 2);
        if (countWays(half) < k)
            return "";
        StringBuilder left = new StringBuilder();
        int len = s.length() / 2;
        for (int pos = 0; pos < len; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0)
                    continue;
                half[c]--;
                long ways = countWays(half);
                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(left);
        ans.append(mid);
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
    void buildComb(int n) {
        for (int i = 0; i <= n; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= Math.min(i, 26); j++) {
                if (j == i)
                    C[i][j] = 1;
                else
                    C[i][j] = Math.min(LIMIT, C[i - 1][j - 1] + C[i - 1][j]);
            }
        }
    }
    long countWays(int[] half) {
        int total = 0;
        for (int x : half)
            total += x;
        long res = 1;
        int rem = total;
        for (int x : half) {
            if (x == 0)
                continue;
            res *= choose(rem, x);
            if (res >= LIMIT)
                return LIMIT;
            rem -= x;
        }
        return res;
    }
    long choose(int n, int r) {
        if (r == 0 || r == n)
            return 1;
        r = Math.min(r, n - r);
        long ans = 1;
        for (int i = 1; i <= r; i++) {
            ans = ans * (n - i + 1) / i;
            if (ans >= LIMIT)
                return LIMIT;
        }
        return ans;
    }
}
