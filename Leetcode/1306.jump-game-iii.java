class Solution {
    public boolean canReach(int[] arr, int start) {
        int N = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(arr[curr]==0) return true;
            int left = curr+arr[curr], right = curr-arr[curr];
            if(left>=0 && left<N && !visited[left]){
                visited[left] = true;
                queue.add(left);
            } 
            if(right>=0 && right<N && !visited[right]){
                visited[right] = true;
                queue.add(right);
            } 
        }
        return false;
    }
}
