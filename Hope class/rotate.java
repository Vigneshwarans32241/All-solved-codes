import java.util.*;
public class rotate{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        for(int i = n-1;i<n+s.length()-1;i++) System.out.print(s.charAt(i%s.length()));
    }
}