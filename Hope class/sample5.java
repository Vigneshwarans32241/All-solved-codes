import java.util.*;
public class sample5 {
    private static int hcf(int a,int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chr = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        Arrays.sort(chr);
        for(char ch:chr){
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        if(map.size()==1){
            System.out.println(chr.length);
            return;
        }
        int hcf = 0;
        for(char ch:map.keySet()){
            hcf = hcf(hcf,map.get(ch));
        }
        System.out.println(hcf);
    }
}
