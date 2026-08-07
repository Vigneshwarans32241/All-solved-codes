import java.util.*;
public class A_Boss_Fight {
    static class Pair {
        int val;
        int freq;
        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> b.freq - a.freq
            );
            for (int key : map.keySet()) {
                pq.offer(new Pair(key, map.get(key)));
            }
            int prev = -1;
            long ans = 0;
            while (!pq.isEmpty()) {
                Pair first = pq.poll();
                if (first.val != prev) {
                    ans += first.val;
                    prev = first.val;
                    first.freq--;
                    if (first.freq > 0) pq.offer(first);
                } else {
                    if (pq.isEmpty()) {
                        ans += first.val;
                        break;
                    }
                    Pair second = pq.poll();
                    ans += second.val;
                    prev = second.val;
                    second.freq--;
                    if (second.freq > 0) pq.offer(second);
                    pq.offer(first);
                }
            }
            System.out.println(ans);
        }
    }
}