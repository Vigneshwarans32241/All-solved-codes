class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        int oddCount = 0, oddChar = -1;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                oddChar = i;
            }
        }
        boolean nOdd = (n % 2 == 1);
        if (nOdd && oddCount != 1) return "";
        if (!nOdd && oddCount != 0) return "";
        int h = n / 2;
        int[] halfFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            int cnt = freq[i];
            if (nOdd && i == oddChar) cnt--;
            halfFreq[i] = cnt / 2;
        }
        char mid = nOdd ? (char) ('a' + oddChar) : 0;
        String tPrefix = target.substring(0, h);
        int[] prefixFreq = new int[26];
        for (char c : tPrefix.toCharArray()) prefixFreq[c - 'a']++;
        boolean matches = true;
        for (int i = 0; i < 26; i++) {
            if (prefixFreq[i] != halfFreq[i]) { matches = false; break; }
        }
        if (matches) {
            String candidate = buildPalindrome(tPrefix, mid, nOdd);
            if (candidate.compareTo(target) > 0) return candidate;
        }
        String greater = nextGreaterPermutation(halfFreq, tPrefix);
        if (greater.isEmpty()) return "";
        return buildPalindrome(greater, mid, nOdd);
    }

    private String buildPalindrome(String firstHalf, char mid, boolean nOdd) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstHalf);
        if (nOdd) sb.append(mid);
        sb.append(new StringBuilder(firstHalf).reverse());
        return sb.toString();
    }

    private String nextGreaterPermutation(int[] origFreq, String target) {
        int n = target.length();
        int[] freq = origFreq.clone();
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            int t = target.charAt(i) - 'a';
            if (freq[t] > 0) {
                ans[i] = target.charAt(i);
                freq[t]--;
            } else {
                for (int c = t + 1; c < 26; c++) {
                    if (freq[c] > 0) return assemble(ans, i, c, freq);
                }
                for (int j = i - 1; j >= 0; j--) {
                    int t2 = target.charAt(j) - 'a';
                    freq[t2]++;
                    for (int c = t2 + 1; c < 26; c++) {
                        if (freq[c] > 0) return assemble(ans, j, c, freq);
                    }
                }
                return "";
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int t = target.charAt(i) - 'a';
            freq[t]++;
            for (int c = t + 1; c < 26; c++) {
                if (freq[c] > 0) return assemble(ans, i, c, freq);
            }
        }
        return "";
    }

    private String assemble(char[] ans, int pos, int c, int[] freq) {
        StringBuilder res = new StringBuilder();
        for (int k = 0; k < pos; k++) res.append(ans[k]);
        res.append((char) ('a' + c));
        freq[c]--;
        for (int k = 0; k < 26; k++)
            while (freq[k]-- > 0) res.append((char) ('a' + k));
        return res.toString();
    }
}
