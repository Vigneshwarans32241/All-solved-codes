import java.util.*;
import java.lang.Math;
public class hex {
    public static int sum = 0;
    public static int bin(int n){
        if(n==0) return 0;
        bin(n/2);
        sum+=(n%2);
        sum*=10;
        return sum;
    }
    public static void he(int n){
        if(n==0) return;
        he(n/1000);
        int a = n%1000,num = 0;
        for(int i = 0;i<4;i++){
            num+=(a%10)*Math.pow(2,i);
        }
        if(num>9){
            char c = (char)('a'+num-10);
            System.out.print(c);
        }
        else{
            System.out.print(num);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = hex.bin(sc.nextInt());
        System.out.println(n);
        sc.close();
    }
}
