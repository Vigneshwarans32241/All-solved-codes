class Solution {
    private int digitsum(int n){
        int temp = n;
        int sum = 0;
        while(temp>0){
            sum += temp%10;
            temp /= 10;
        }
        return sum;
    }
    private int digitprod(int n){
        int temp = n;
        int prod = 1;
        while(temp>0){
            prod *= temp%10;
            temp /= 10;
        }
        return prod;
    }
    public boolean checkDivisibility(int n) {
        int sum = digitsum(n);
        int prod = digitprod(n);
        int add = sum + prod;
        return (n%add==0);
    }
}
