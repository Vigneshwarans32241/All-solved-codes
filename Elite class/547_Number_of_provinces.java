class Solution {
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        int leader[] = new int[N+1];
        int ans = 0;
        for(int i = 0;i<=N;i++) leader[i] = i; 
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(isConnected[i][j] == 1){
                    join(leader, i + 1, j + 1);
                }
            }
        }
        for(int i = 1;i<=N;i++){
            if(find(leader,i)==i) ans++;
        }
        return ans;
    }
    private static int find(int leader[],int node){
        if(leader[node]!=node) leader[node] = find(leader,leader[node]);
        return leader[node];
    }
    private static void join(int leader[],int left,int right){
        leader[find(leader,right)] = find(leader,left);
    }
}
