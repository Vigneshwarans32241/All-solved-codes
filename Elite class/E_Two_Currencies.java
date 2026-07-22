import java.util.*;
public class E_Two_Currencies {
    static class Edge{
        int dest,cost,time;
        Edge(int dest,int cost,int time){
            this.dest = dest;
            this.cost = cost;
            this.time = time;
        }
    }
    static class Pair implements Comparable<Pair>{
        long t;
        int city,silver;
        Pair(long t, int city,int silver){
            this.silver = silver;
        this.t = t;
        this.city = city;
        }
        public int compareTo(Pair oth){
            return Long.compare(this.t,oth.t);
        }
    }
    static long inf = Long.MAX_VALUE/4;
    static int maxsilver = 2500;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int S = sc.nextInt();
        Map<Integer, List<Edge>> g = new HashMap<>();
        for(int c = 1;c<=N;c++) g.put(c,new ArrayList<>());
        for(int c = 1;c<=M;c++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int cost = sc.nextInt();
            int t = sc.nextInt();
            g.get(src).add(new Edge(dest,cost,t));
            g.get(dest).add(new Edge(src,cost,t));
        }
        int[][] ex = new int[N+1][2];
        for(int c = 1;c<=N;c++){
            ex[c][0] = sc.nextInt();
            ex[c][1] = sc.nextInt();
        }
        // long tarr[] = new long[N+1];
        S = Math.min(S,maxsilver);
        long[][] dist = new long[N+1][maxsilver+1];
        for(int i = 1 ;i<=N;i++){
            Arrays.fill(dist[i], inf);
        }
        PriorityQueue<Pair> q = new PriorityQueue<>();
        dist[1][S]=0;
        q.add(new Pair(0L,1,S));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.t != dist[curr.city][curr.silver]) continue;
            int news = Math.min(maxsilver,curr.silver+ex[curr.city][0]);
            long newt = curr.t+ex[curr.city][1];
            if(newt<dist[curr.city][news]){
                dist[curr.city][news] = newt;
                q.add(new Pair(newt,curr.city,news));
            }            
            for(Edge e : g.get(curr.city)){
                if(curr.silver>=e.cost){
                    news = curr.silver-e.cost;
                    newt = curr.t+e.time;
                    if(newt< dist[e.dest][news]){
                        dist[e.dest][news] = newt;
                        q.add(new Pair(newt,e.dest,news));
                    }
                }
            }
        }
        for(int c = 2;c<=N;c++){
            long ans = inf;
            for(int s = 0;s<=maxsilver;s++){
                ans = Math.min(ans,dist[c][s]);
            }
            System.out.println(ans);
        }
    }
}
