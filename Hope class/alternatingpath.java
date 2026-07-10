import java.util.*;
public class alternatingpath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Integer>[] adj = new ArrayList[n+1];
            for(int index = 1;index<=n;index++) adj[index] = new ArrayList<>();
            for(int index = 0;index<m;index++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            int[] colors = new int[n+1];
            Arrays.fill(colors, -1);
            int ans = 0;
            for(int num = 1;num<=n;num++){
                if(colors[num]!=-1) continue;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(num);
                colors[num] = 0;
                int count0 = 1,count1 = 0;
                boolean isbipartite = true;
                while(!queue.isEmpty()){
                    int u = queue.poll();
                    for(int v: adj[u]){
                        if(colors[v]==-1){
                            colors[v] = colors[u] ^ 1;
                            if(colors[v]==0) count0++;
                            else count1++;
                            queue.add(v);
                        }
                        else if(colors[v]==colors[u]){
                            isbipartite=false;
                        }
                    }
                }
                if(isbipartite){
                    ans+=Math.max(count0,count1);
                }
            }
            System.out.println(ans);
        }
    }
}
