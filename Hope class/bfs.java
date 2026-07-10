// import java.util.*;
// public class bfs {
//     public static char[][] grid;
//     private static int bfs(Queue<int[]> queue,boolean[][] visited,int R, int C){
//         int[] dx = {-1,1,0,0};
//         int[] dy = {0,0,-1,1};
//         while(!queue.isEmpty()){
//             int[] cell = queue.poll();
//             for(int ctr = 0;ctr<dx.length;ctr++){
//                 int nx = cell[0]+dx[ctr],ny = cell[1]+dy[ctr];
//                 if(nx<0 || nx>=R || ny<0 || ny>=C || visited[nx][ny] || grid[nx][ny]=='#') continue;
//                 if(grid[nx][ny]=='C'){
//                     return cell[2]+1;
//                 }
//                 visited[nx][ny] = true;
//                 queue.add(new int[]{nx,ny,cell[2]+1});
//             }
//         }
//         return -1;   
//     }

//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int R = sc.nextInt(),C = sc.nextInt();
//         sc.nextLine();
//         grid = new char[R][C];
//         Queue<int[]> Aqueue = new LinkedList<>();
//         Queue<int[]> Bqueue = new LinkedList<>();
//         boolean[][] Avisited = new boolean[R][C];
//         boolean[][] Bvisited = new boolean[R][C];
//         for(int ctr = 0;ctr<R;ctr++){
//             String s = sc.nextLine();
//             for(int strindex = 0;strindex<s.length();strindex++){
//                 grid[ctr][strindex] = s.charAt(strindex);
//                 if(s.charAt(strindex)=='A'){
//                     Aqueue.add(new int[]{ctr,strindex,0});
//                     Avisited[ctr][strindex] = true;
//                 }
//                 if(s.charAt(strindex)=='B'){
//                     Bqueue.add(new int[]{ctr,strindex,0});
//                     Bvisited[ctr][strindex] = true;
//                 }
//             }
//         }
//         int Adist = bfs(Aqueue,Avisited,R,C);
//         int Bdist = bfs(Bqueue,Bvisited,R,C);    
//         if(Adist == -1 && Bdist == -1) System.out.println("AB");
//         else if(Adist == -1) System.out.println("B");
//         else if(Bdist == -1) System.out.println("A");
//         else if(Adist < Bdist) System.out.println("A");
//         else if(Bdist < Adist) System.out.println("B");
//         else System.out.println("AB");
//     }
// }
import java.util.*;
class bfs{
    private static int[] dR= {0,0,-1,1}, dC = {-1,1,0,0};
    private static boolean[][] visited;
    private static int bfs(int R,int C,char[][] grid,Queue<int[]> queue,int endR,int endC){
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0],c = curr[1], dist = curr[2];
            visited[r][c] = true;
            if(r==endR && c==endC) return dist;
            for(int d = 0;d<4;d++){
                int newR = r+dR[d];
                int newC = c+dC[d];
                if(newR>=0 && newR<R && newC>=0 && newC<C && !visited[newR][newC] && grid[newR][newC]!='|'){
                    visited[newR][newC] = true;
                    queue.add(new int[]{newR,newC,dist+1});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        Queue<int[]> queue = new LinkedList<>();
        int endR = -1,endC = -1;
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                grid[i][j] = sc.next().charAt(0);
                if(grid[i][j]=='R'){
                    queue.add(new int[]{i,j,0});
                }
                if(grid[i][j]=='C'){
                    endR = i;
                    endC = j;
                }
            }
        }
        visited = new boolean[R][C];
        System.out.print(bfs(R,C,grid,queue,endR,endC));
    }
}