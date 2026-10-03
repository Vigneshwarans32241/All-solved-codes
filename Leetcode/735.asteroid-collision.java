class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int N = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<N;i++){
            int x = asteroids[i];
            boolean alive = true;
            if(x<0){
                while(alive && !stack.isEmpty() && stack.peek()>0){
                    if(stack.peek()<Math.abs(x)) stack.pop();
                    else if(stack.peek()==Math.abs(x)){
                        stack.pop();
                        alive = false;
                    }
                    else{
                        alive = false;
                    }
                }
            }
            if(alive) stack.push(x);
        }
        int[] ans = new int[stack.size()];
        for(int i = 0;i<stack.size();i++) ans[i] = stack.get(i);
        return ans;
    }   
}
