class Solution {
    public int numIslands(char[][] grid) {
        int R = grid.length,C = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                if(grid[i][j]=='1'){
                    count++;
                    queue.add(new int[]{i,j});
                    grid[i][j]='0';
                    while(!queue.isEmpty()){
                        int[] curr = queue.poll();
                        for(int d = 0;d<4;d++){
                            int newr = curr[0]+dx[d];
                            int newc = curr[1]+dy[d];
                            if(newr<R && newc<C && newr>=0 && newc>=0 && grid[newr][newc]=='1'){
                                queue.add(new int[]{newr,newc});
                                grid[newr][newc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
