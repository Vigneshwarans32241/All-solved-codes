import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(q-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0;i<=n;i++) graph.add(new ArrayList<>());
            for(int i = 0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            int start = sc.nextInt();
            int[] distance = new int[n+1];
            Arrays.fill(distance,-1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            distance[start] = 0;
            while(!queue.isEmpty()){
                int curr = queue.poll();
                for(int neighbour : graph.get(curr)){
                    if(distance[neighbour]==-1){
                        distance[neighbour] = distance[curr]+6;
                        queue.add(neighbour);
                    }
                }
            }
            for(int i = 1;i<=n;i++){
                if(i!=start){
                    System.out.print(distance[i]+" ");
                }
            }
            System.out.println();
        }
    }
}

