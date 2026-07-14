import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int maxTime = 0;
            int len = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '#') {
                    len++;
                } else {
                    if (len > 0) {
                        maxTime = Math.max(maxTime, (len + 1) / 2);
                        len = 0;
                    }
                }
            }
            if (len > 0) {
                maxTime = Math.max(maxTime, (len + 1) / 2);
            }
            System.out.println(maxTime);
        }
    }
}
