class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()==1) return s;
        int n = s.length();
        String half = getHalf(s);
        return half+ (n%2==1 ?  String.valueOf(s.charAt(n/2)): "") + reverseString(half);
    }
    private String getHalf(String s){
        String half = s.substring(0,s.length()/2);
        char[] chars = half.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    private String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
