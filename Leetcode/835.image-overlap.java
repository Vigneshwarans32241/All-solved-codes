class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int N = img1.length;
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(img1[i][j]==1) ones1.add(new int[]{i,j});
                if(img2[i][j]==1) ones2.add(new int[]{i,j});
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        for(int[] p1 : ones1){
            for(int[] p2 : ones2){
                int dr = p2[0]-p1[0];
                int dc = p2[1]-p1[1];
                String key = dr+","+dc;
                int count = map.getOrDefault(key,0)+1;
                map.put(key,count);
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}
