import java.util.*;
public class B_Evanescent {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            String S = sc.next();
            int groups = 1;
            for(int i = 1;i<n;i++){
                if(S.charAt(i)!=S.charAt(i-1)) groups++;
            }
            int ans = Integer.MAX_VALUE;
            for(int i = 1;i<n-1;i++){
                int before = 0, after = 0;
                if(S.charAt(i-1)!=S.charAt(i)) before++;
                if(S.charAt(i)!=S.charAt(i+1)) before++;
                if(S.charAt(i-1)!=S.charAt(i+1)) after++;
                int newgroups = groups - before + after;
                ans = Math.min(ans,newgroups);
            }
            System.out.println(ans);
        }
    }
}
