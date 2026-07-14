import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int[] p = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }
            int[] comp = new int[n + 1];
            int id = 0;
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (comp[i] != 0) continue;
                id++;
                comp[i] = id;
                q.offer(i);
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    int[] nxt = {
                            cur - x, cur + x,
                            cur - y, cur + y
                    };
                    for (int v : nxt) {
                        if (v >= 1 && v <= n && comp[v] == 0) {
                            comp[v] = id;
                            q.offer(v);
                        }
                    }
                }
            }
            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                if (comp[i] != comp[p[i]]) {
                    ok = false;
                    break;
                }
            }
            out.append(ok ? "YES" : "NO").append('\n');
        }
        System.out.print(out);
    }
}

