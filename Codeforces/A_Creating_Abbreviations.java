import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean[] available = new boolean[26];
            for (int i = 0; i < n; i++) {
                String word = sc.next();
                available[word.charAt(0) - 'a'] = true;
            }
            String[] abbr = new String[m];
            for (int i = 0; i < m; i++) abbr[i] = sc.next();
            boolean[] created = new boolean[m];
            int count = 0;
            while (true) {
                boolean progress = false;
                for (int i = 0; i < m; i++) {
                    if (created[i]) continue;
                    String s = abbr[i];
                    boolean possible = true;
                    for (char c : s.toCharArray()) {
                        if (!available[c - 'A']) {
                            possible = false;
                            break;
                        }
                    }
                    if (possible) {
                        created[i] = true;
                        count++;
                        progress = true;
                        available[s.charAt(0) - 'A'] = true;
                    }
                }
                if (!progress) break;
            }
            System.out.println(count == m ? "YES" : "NO");
        }
    }
}
