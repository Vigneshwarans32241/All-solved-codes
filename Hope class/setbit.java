import java.util.*;
public class setbit {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int i = 0;
        while(n>0){
            n&=n-1;
            i++;
        }
        System.out.print(i);
        sc.close();
    }
}
