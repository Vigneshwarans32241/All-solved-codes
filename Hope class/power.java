import java.util.*;
public class power {
    public static void main(String[] args){
        int i = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n!=0){
            if(n%2==1){
                System.out.print((1<<i)+"+");
            }
            n/=2;
            i++;
        }
        sc.close();
    }
}
