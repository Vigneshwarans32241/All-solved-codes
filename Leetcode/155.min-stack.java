class MinStack {

    class Node{
        int val;
        int min;
        Node(int val,int min){
            this.val = val;
            this.min = min;
        }
    }
    Stack<Node> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int value) {
        int curr;
        if(stack.isEmpty()) curr = value;
        else curr = Math.min(value,stack.peek().min);
        stack.push(new Node(value,curr));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
