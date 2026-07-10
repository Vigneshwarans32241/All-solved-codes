import java.util.*;
public class binary {
    public static void bin(int n){
        StringBuilder sb = new StringBuilder();
       while(n>0){
        sb.append((n&1));
        n=(n>>1);
       }
       System.out.print(sb.reverse());
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        binary.bin(sc.nextInt());
        sc.close();
    }
}
