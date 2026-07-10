import java.util.*;
public class recursion {
    public static    int a = 1;
    public static void head(int n,int a){
        if(a<=n){
            System.out.print(a+"\n");
            head(n,a+1);
        }
    }
    public static void tail(int n){
        if(n>=0){
            System.out.print(n+"\n");
            tail(n-1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recursion.head(n,a);
        System.out.println("\n");
        recursion.tail(n);
        sc.close();
    }
}
