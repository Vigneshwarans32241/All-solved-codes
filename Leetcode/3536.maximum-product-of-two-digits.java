class Solution {
    public int maxProduct(int n) {
        String num = String.valueOf(n);
        char[] chars = num.toCharArray();
        Arrays.sort(chars);
        int last = chars[chars.length-1]-'0';
        int lastbefore = chars[chars.length-2]-'0';
        return last*lastbefore;
    }
}
