class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int R = image.length, C = image[0].length;
        int original = image[sr][sc];
        if(original==color) return image;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr,sc});
        image[sr][sc] = color;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int d = 0;d<4;d++){
                int newr = curr[0]+dx[d];
                int newc = curr[1]+dy[d];
                if(newr<R && newc<C && newr>=0 && newc>=0 && image[newr][newc]==original){
                    image[newr][newc] = color;
                    queue.add(new int[] {newr,newc});
                } 
            }
        }
        return image;
    }
}
