class Solution {
    private int pod(int n){
        if(n==0) return 1;
        return (n%10)*pod(n/10);
    }
    public int smallestNumber(int n, int t) {
        while(true){
            int prod = pod(n);
            if(prod%t==0) return n;
            n++;
        }
    }
}
