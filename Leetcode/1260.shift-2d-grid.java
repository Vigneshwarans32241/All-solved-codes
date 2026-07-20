class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int R = grid.length;
        int C = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        int total = R*C;
        k = k%total;
        for(int i = 0;i<R;i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0;j<C;j++){
                row.add(0);
            }
            ans.add(row);
        }
        
        // if(k==0){
        //     for(int i = 0;i<R;i++){
        //         for(int j = 0;j<C;j++){
        //             ans.get(i).add(grid[i][j]);
        //         }
        //     }
        //     return ans;
        // }
        // ans.get(0).add(grid[R-1][C-1]);
        // for(int i = 0;i<R;i++){
        //     for(int j = 0;j<C;j++){
        //         if(j==C-1 && i==R-1) continue;
        //         if(j==C-1) ans.get(i+1).add(grid[i][j]);
        //         else ans.get(i).add(grid[i][j]);
        //     }
        // }
        // k--;
        // while(k-->0){
        //     ans = solve(ans,grid,R,C);
        // }
        // return ans;

        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                int index = i*C+j;
                int newIndex = (index+k)%total;
                int newR = newIndex/C;
                int newC = newIndex%C;
                ans.get(newR).set(newC,grid[i][j]);
            }
        }
        return ans;
    }
    // private List<List<Integer>> solve(List<List<Integer>> ans,int[][] grid,int R,int C){
    //     List<List<Integer>> newans = new ArrayList<>();
    //     for(int i = 0;i<R;i++) newans.add(new ArrayList<>());
    //     newans.get(0).add(ans.get(R-1).get(C-1));
    //     // ans.get(0).add(grid[R-1][C-1]);
    //     for(int i = 0;i<R;i++){
    //         for(int j = 0;j<C;j++){
    //             if(j==C-1 && i==R-1) continue;
    //             if(j==C-1) newans.get(i+1).add(ans.get(i).get(j));
    //             else newans.get(i).add(ans.get(i).get(j));
    //         }
    //     }
    //     return newans;
    // }
}
