class Solution {
    public int sumSubarrayMins(int[] arr) {
        int N = arr.length;
        long ans = 0;
        long MOD = 1000000007;
        int[] left = new int[N];
        int[] right = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        left[0] = -1;
        for(int i = 1;i<N;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();
            if(stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = N-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) stack.pop();
            if(stack.isEmpty()) right[i] = N;
            else right[i] = stack.peek();
            stack.push(i);
        }
        for(int i = 0;i<N;i++){
            long count = (long)(i-left[i]) * (right[i]-i);
            ans = (long)(ans+(count*arr[i]))%MOD;
        }
        return (int)ans;
    }
}
