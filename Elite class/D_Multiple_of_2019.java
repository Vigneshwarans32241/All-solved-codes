import java.util.*;
public class D_Multiple_of_2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long ans = 0;
        int rem = 0,pv=1,BASE=2019;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = s.length()-1;i>=0;i--){
            rem = (rem+(s.charAt(i)-'0')*pv)%BASE;
            if(map.containsKey(rem)){
                ans+=map.get(rem);
                map.put(rem,map.get(rem)+1);
            }
            else{
                map.put(rem,1);
            }
            pv = (pv*10)%BASE;
        }
        System.out.println(ans  );
    }

}