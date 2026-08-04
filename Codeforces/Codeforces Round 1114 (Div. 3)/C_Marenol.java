import java.util.*;
class C_Marenol{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            int a1count = 0, b1count = 0;
            int atotal = 0, btotal = 0;
            for(int i = 0;i<n;i++){
                if(a.charAt(i)=='1'){
                    atotal++;
                    if(i%2==0) a1count++;
                }
                if(b.charAt(i)=='1'){
                    btotal++;
                    if(i%2==0) b1count++;
                }
            }
            if(a1count==b1count && atotal==btotal) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}