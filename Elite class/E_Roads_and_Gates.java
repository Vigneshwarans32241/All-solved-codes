import java.util.*;
public class E_Roads_and_Gates {
    static class Pair implements Comparable<Pair>{
        Long t;
        int city;
        Pair(Long t, int city){
        this.t = t;
        this.city = city;
        }
        public int compareTo(Pair oth){
            return this.t.compareTo(oth.t);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Y = sc.nextInt();
        Map<Integer, List<int[]>> g = new HashMap<>();
        for(int c = 1;c<=N+2;c++){
            g.put(c,new ArrayList<>());
        }
        for(int r=1;r<=M;r++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int t = sc.nextInt();
            g.get(src).add(new int[]{dest,t});
            g.get(dest).add(new int[]{src,t});
        }
        g.get(N+1).add(new int[]{N+2, Y});
        for(int c = 1;c<=N;c++){
            int wgt = sc.nextInt();
            g.get(c).add(new int[]{N+1,wgt});
            g.get(N+2).add(new int[]{c,wgt});
        }
        long[] tarr = new long[N+3];
        for(int c = 1;c<=N+2;c++){
            tarr[c] = Long.MAX_VALUE;
        }
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0L,1));
        tarr[1] = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            long currtime = p.t;
            int currcity = p.city;
            if(currtime > tarr[currcity]) continue;
            for(int[] lcp : g.get(currcity)){
                long newtime = currtime + lcp[1];
                int newcity = lcp[0];
                if(tarr[newcity]>newtime){
                    q.add(new Pair(newtime, newcity));
                    tarr[newcity] = newtime;
                }
            }
        }
        for(int c = 2;c<=N;c++){
            System.out.print(tarr[c]+" ");
        }
    }
}