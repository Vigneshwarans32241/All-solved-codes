class Solution {
    public String reverseWords(String s) {
        int N = s.length();
        String ans = "";
        String[] words = s.split(" ");
        for(String word : words){
            for(int i = word.length()-1;i>=0;i--) ans+=word.charAt(i);
            ans+=" ";
        }
        return ans.substring(0,ans.length()-1);
    }
}
