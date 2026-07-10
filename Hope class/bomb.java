public class bomb {
    static boolean[][] visited;
    public static int max=0;
    public static void dfs(int[][] grid,int i,int j){
        int r = grid.length;
        int c = grid[0].length;
        if(i<0 || j<0 ||i>=r||j>=c) return;
        if(grid[i][j]==0 || visited[i][j]) return;
        visited[i][j] = true;
        if(grid[i][j]>max) max = grid[i][j];
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
    }
    public static void main(String[] args){
        int[][] grid = {{5,2,0,6,5},{10,1,0,8,1},{4,7,0,7,3},{0,0,6,5,7}};
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]!=0 && visited[i][j]==false){
                    max = 0;
                    if(grid[i][j]>max) max = grid[i][j];
                    dfs(grid,i,j);
                    System.out.println(max);
                }
            }
        }

    }
}
