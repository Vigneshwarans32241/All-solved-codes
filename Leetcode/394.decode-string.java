class Solution {
    public String decodeString(String s) {
        Stack<Integer> countstack = new Stack<>();
        Stack<String> strstack = new Stack<>();
        String curr = "";
        int num = 0;
        for(int i = 0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))) num =num*10+(s.charAt(i)-'0');
            else if(s.charAt(i)=='['){
                countstack.push(num);
                strstack.push(curr);
                num = 0;
                curr = "";
            }
            else if(s.charAt(i)==']'){
                int repeat = countstack.pop();
                String prev = strstack.pop();
                String temp = curr;
                curr = prev;
                for(int j = 0;j<repeat;j++) curr+=temp;
            }
            else{
                curr+=s.charAt(i);
            }
        }
        return curr;
    }
}
