import java.util.*;
import java.lang.Math;
public class newyearcake {
    public static int calc(int a,int b){
        int layers = 0;
        for(int i = 0;i>=0;i++){
            if(i%2==0){
                if(a>=(1<<i)){ a-=(1<<i); layers++;}
                else break;
            }
            else{
                if(b>=(1<<i)){ b-=(1<<i); layers++;}
                else break;
            }
        }
        return layers;
    }
    public static int layers(int a,int b){
        return(Math.max(calc(a,b),calc(b,a)));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = layers(a,b);
            System.out.print(ans);
        }
        sc.close();
    }
}
