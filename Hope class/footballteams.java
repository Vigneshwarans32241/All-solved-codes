import java.util.*;
public class footballteams {
    public static void main(String[] args){
        int n,ans = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1;i<=n+n+1;i++){
            int curr;
            curr = sc.nextInt();
            ans^=curr;
        }
        System.out.print(ans);
        sc.close();
    }
}
