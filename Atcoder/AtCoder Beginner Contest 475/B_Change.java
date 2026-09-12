import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int one = 0, two = 0, three = 0;
        for(int i= 0 ; i<N;i++){
            int amt = sc.nextInt();
            int pay = 1000;
            while(pay<amt) pay+=1000;
            int diff = pay-amt;
            one += diff%10;
            diff/=10;
            two+=diff%10;
            diff/=10;
            three+=diff%10;
        }
        System.out.print(one+" "+two+" "+three);
    }
}
