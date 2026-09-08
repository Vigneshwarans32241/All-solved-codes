import java.util.*;
class B_Minus_Two{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        int N = sc.nextInt();
        int odd = 0,oddq = 0,eq = 0;
        for(int i = 0 ;i<N;i++){
            int num = sc.nextInt();
            if(num%2==1) odd++;
            else{
            if((num/2)%2==0) eq++;
            else oddq++; }
        }
        System.out.println("Odd:"+odd+"\nOddq:"+oddq+"\nevenq:"+eq);
        System.out.println(Math.max(odd,Math.max(eq,oddq)));
    }
}