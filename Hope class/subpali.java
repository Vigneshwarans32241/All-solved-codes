import java.util.*;
public class subpali {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] left = new int[26];
        int[] right = new int[26];
        int ans = 0;
        for(int i =0;i<s.length();i++){
            right[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<s.length();i++){
            right[s.charAt(i)-'a']--;
            for(int j = 0;j<26;j++){
                ans+=left[j]*right[j];
            }
            left[s.charAt(i)-'a']++;
        }
        System.out.print(ans);
        sc.close();
    }

}
