class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            int t = target.charAt(i) - 'a';
            if (freq[t] > 0) {
                ans[i] = target.charAt(i);
                freq[t]--;
            } else {
                for (int c = t + 1; c < 26; c++) {
                    if (freq[c] > 0) {
                        StringBuilder res = new StringBuilder();
                        for (int k = 0; k < i; k++) res.append(ans[k]);
                        res.append((char)('a' + c));
                        freq[c]--;
                        for (int k = 0; k < 26; k++)
                            while (freq[k]-- > 0) res.append((char)('a' + k));
                        return res.toString();
                    }
                }
                for (int j = i - 1; j >= 0; j--) {
                    int t2 = target.charAt(j) - 'a';
                    freq[t2]++;
                    for (int c = t2 + 1; c < 26; c++) {
                        if (freq[c] > 0) {
                            StringBuilder res = new StringBuilder();
                            for (int k = 0; k < j; k++) res.append(ans[k]);
                            res.append((char)('a' + c));
                            freq[c]--;
                            for (int k = 0; k < 26; k++)
                                while (freq[k]-- > 0) res.append((char)('a' + k));
                            return res.toString();
                        }
                    }
                }
                return "";
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int t = target.charAt(i) - 'a';
            freq[t]++;
            for (int c = t + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    StringBuilder res = new StringBuilder();
                    for (int j = 0; j < i; j++) res.append(ans[j]);
                    res.append((char)('a' + c));
                    freq[c]--;
                    for (int k = 0; k < 26; k++)
                        while (freq[k]-- > 0) res.append((char)('a' + k));
                    return res.toString();
                }
            }
        }
        return "";
    }
}
