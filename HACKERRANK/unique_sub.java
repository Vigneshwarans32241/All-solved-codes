import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] freq = new int[128];

        // Step 1: Find number of unique characters
        int unique = 0;

        for (char c : s.toCharArray()) {
            if (freq[c] == 0) {
                unique++;
            }
            freq[c]++;
        }

        // Reset frequency for the sliding window
        Arrays.fill(freq, 0);

        int left = 0;
        int formed = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Step 2: Find minimum window containing all unique chars
        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            if (freq[c] == 0) {
                formed++;
            }

            freq[c]++;

            // We have all unique characters
            while (formed == unique) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char remove = s.charAt(left);

                freq[remove]--;

                if (freq[remove] == 0) {
                    formed--;
                }

                left++;
            }
        }

        System.out.println(s.substring(start, start + minLen));
        System.out.println(minLen);
    }
}
