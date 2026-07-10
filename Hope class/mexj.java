import java.util.*;
public class mexj {
    public static int mex(Scanner sc){
        int n = sc.nextInt(),k = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0;i<n;i++) set.add(sc.nextInt());
        while(set.size()>k-1){
            set.pollLast();
        }
        for(int i = 0;i<=set.size();i++) if(!set.contains(i)) return i;
        return set.size();

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0;i<t;i++){
            System.out.println(mex(sc));
        }
        sc.close();
    }
}
