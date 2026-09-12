class Solution {
    public boolean rotateString(String s, String goal) {
        int N = s.length();
        for(int i = 0;i<N;i++){
            String left = s.substring(0,i);
            String right = s.substring(i,N);
            System.out.println(right+left);
            if((right+left).equals(goal)) return true;
        }
        return false;
    }
}
