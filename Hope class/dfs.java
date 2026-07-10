import java.util.Scanner;

public class dfs {
    private static boolean[][] visited;
    private static int[][] diff = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] grid = new int[R][C];
        int startrow = 0,startcol = 0;
        visited = new boolean[R][C];
        for(int row = 0;row<R;row++){
            for(int col = 0;col<C;col++){
                grid[row][col] = sc.nextInt();
                if(grid[row][col]==1){
                    startrow = row;
                    startcol = col;
                }
            }
        }
        if(dfs(startrow,startcol,grid,visited,R,C)){
            System.out.println("Found");
        }
        else{
            System.out.println("Not found");
        }
    }
    private static boolean dfs(int row,int col, int[][] grid,boolean[][] visited,int R, int C){
        visited[row][col] = true;
        if(grid[row][col]==2) return true;
        for(int[] pos : diff ){
            int adjR = row+pos[0];
            int adjC = col+pos[1];
            if(adjR>=0 && adjR<R && adjC>=0 && adjC<C && !visited[adjR][adjC] && (grid[adjR][adjC]==3 || grid[adjR][adjC]==2)){
                if(dfs(adjR,adjC,grid,visited,R,C)){ 
                    System.out.println("Path:"+adjR+","+adjC);
                    return true;
                }
            }
        }
        visited[row][col] = false;
        return false;

    }
}
