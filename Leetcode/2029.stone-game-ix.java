class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] rems = new int[3];
        for(int x : stones) rems[x%3]++;
        if(rems[0]%2==0) return Math.min(rems[1],rems[2])>0;
        return Math.abs(rems[1]-rems[2])>2;
    }
}
