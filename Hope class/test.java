import java.util.Scanner;

public class test {
    public static void reverse(String str,int i){
        if(i<0) return;
        System.out.print(str.charAt(i));
        reverse(str,i-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        reverse(str,str.length()-1);
    }
}
