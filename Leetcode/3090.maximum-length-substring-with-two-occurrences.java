class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<=n;j++){
                HashMap<Character,Integer> map = new HashMap<>();
                String sub = s.substring(i,j);
                boolean valid = true;
                for(char c : sub.toCharArray()){
                    map.put(c,map.getOrDefault(c,0)+1);
                    if(map.get(c)>2){
                        valid = false;
                        break;
                    }
                }
                if(valid) max = Math.max(max,j-i);
            }
        }
        return max;
    }
}
