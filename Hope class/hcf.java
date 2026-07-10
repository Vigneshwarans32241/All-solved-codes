import java.util.*;
public class hcf {
    public static void main(String arg[]){
        int a,b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        while(a!=b){
            if(a>b) a-=b;
            else b-=a;
        }
        System.out.print(a);
        sc.close();
    }
}
