import java.util.*;
public class chokutter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),T=sc.nextInt(),time = 0;
        boolean closed = false;
        List<Integer> akoi = new ArrayList<>();
        for(int i = 0;i<N;i++) akoi.add(sc.nextInt());
        int i = 0;
        if(N>0){
            while(i<=T){
                if(!closed && akoi.contains(i)){
                    i+=100;
                }
                else{
                    i++;
                    time++;
                }
            }
            System.out.print(time);
        }
        else{
            System.out.print(T);
        }
    }
}