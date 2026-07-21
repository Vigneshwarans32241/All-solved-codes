class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        List<Integer> zeros = new ArrayList<>();
        int max = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                if(i>0 && s.charAt(i-1)=='0') zeros.set(zeros.size()-1,zeros.get(zeros.size()-1)+1);
                else zeros.add(1);
            }
        }
        for(int i = 0;i<zeros.size()-1;i++){
            max = Math.max(max,zeros.get(i)+zeros.get(i+1));
        }
        return (int) s.chars().filter(c->c=='1').count()+max;
    }
}
