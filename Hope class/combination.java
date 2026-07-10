import java.util.*;
public class combination {
    public static void combo(String s){
        int n = s.length();
        for(int mask = 1;mask<(1<<n);mask++){
            StringBuilder str = new StringBuilder();
            for(int i = 0;i<n;i++){
                if((mask&(1<<n-1-i))!=0){
                    str.append(s.charAt(i));
                }
            }
            System.out.println(str);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        combo(str);
        sc.close();
    }
}
