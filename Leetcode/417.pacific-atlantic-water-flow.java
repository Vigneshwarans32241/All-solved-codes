class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int R = heights.length,C = heights[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] pacific = new int[R][C];
        int[][] atlantic = new int[R][C];
        boolean[][] seen1 = new boolean[R][C];
        boolean[][] seen2 = new boolean[R][C];
        for(int i = 0;i<R;i++){
            queue.add(new int[]{i,0});
            seen1[i][0] = true;
        }
        for(int i = 0;i<C;i++){
            queue.add(new int[]{0,i});
            seen1[0][i] = true;
        }
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int d = 0;d<4;d++){
                int newr = curr[0]+dx[d];
                int newc = curr[1]+dy[d];
                if(newr<R && newc<C && newr>=0 && newc>=0 && heights[newr][newc]>=heights[curr[0]][curr[1]] && !seen1[newr][newc]){
                    queue.add(new int[]{newr,newc});
                    seen1[newr][newc] = true;
                }
            }
        }
        queue.clear();
        for(int i = 0;i<R;i++){
            queue.add(new int[]{i,C-1});
            seen2[i][C-1] = true;
        }
        for(int i = 0;i<C;i++){
            queue.add(new int[]{R-1,i});
            seen2[R-1][i] = true;
        }
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int d = 0;d<4;d++){
                int newr = curr[0]+dx[d];
                int newc = curr[1]+dy[d];
                if(newr<R && newc<C && newr>=0 && newc>=0 && heights[newr][newc]>=heights[curr[0]][curr[1]] && !seen2[newr][newc]){
                    queue.add(new int[]{newr,newc});
                    seen2[newr][newc] = true;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                if(seen1[i][j] && seen2[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}
