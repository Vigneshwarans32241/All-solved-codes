class Solution {
    public String removeOuterParentheses(String s) {
        int N = s.length();
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for(int i = 0;i<N;i++){
            char c = s.charAt(i);
            if(c=='('){
                if(balance>0){
                    sb.append(c);
                    
                }
                balance++;
            }
            else{
                balance--;
                if(balance!=0) sb.append(c);
                
            }
        }
        return sb.toString();        
    }
}
