class Solution {
    public int shortestPath(int[][] grid, int k) {
        int R = grid.length, C = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,k});
        int[][] visited = new int[R][C];
        for(int[] row : visited) Arrays.fill(row,-1);
        visited[0][0] = k;
        int steps = 0;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int[] curr = queue.poll();
                if(curr[0]==R-1 && curr[1]==C-1) return steps;
                for(int d = 0;d<4;d++){
                    int newr = curr[0]+dx[d];
                    int newc = curr[1]+dy[d];
                    int newk = 0;
                    if(newr<R && newc<C && newr>=0 && newc>=0){
                        if(grid[newr][newc]==0) newk = curr[2];
                        else newk = curr[2]-1;
                        if(newk>=0 && newk>visited[newr][newc]){
                            queue.add(new int[]{newr,newc,newk});
                            visited[newr][newc] = newk;
                        }
                    }
                }
            }
            steps++;   
        }
        return -1;
    }
}
