import java.util.*;
public class Unbelievable_Array {
    static int parent[] = new int[200005];
    static int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1;tc<=T;tc++){
            
            int N = sc.nextInt();
            int OPS = sc.nextInt();
            int arr[] = new int[N+1];
            int nodevalue[] = new int[N+OPS+5];
            HashMap<Integer,Integer> id = new HashMap<>();
            int next = 1;
            for(int i = 1;i<=N+OPS;i++){
                parent[i] = i;
            }
            for(int i = 1;i<=N;i++){
                int temp = sc.nextInt();
                if(!id.containsKey(temp)){
                    id.put(temp,next);
                    nodevalue[next] = temp;
                    next++;
                }
                arr[i] = id.get(temp);
            }
            System.out.println("Case "+tc+":");
            while(OPS-->0){
                int op = sc.nextInt();  
                if(op==1){
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    if(x==y) continue;
                    if(!id.containsKey(x)) continue;
                    if(!id.containsKey(y)){
                        int root = find(id.get(x));
                        id.remove(x);
                        id.put(y,root);
                        nodevalue[root] = y;
                    }
                    else{
                        int px = find(id.get(x));
                        int py = find(id.get(y));
                        if(px!=py) parent[px] = py;
                        id.remove(x);
                    }
                }
                else{
                    int idx = sc.nextInt();
                    System.out.println(nodevalue[find(arr[idx])]);
                }
          }
        }
    }
}