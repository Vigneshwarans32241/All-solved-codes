import java.util.*;
import java.lang.Math;
public class equal10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(counter,-1);
        int large = 0;
        for(int i = 0;i<str.length();i++){
            if("aeiou".indexOf(str.charAt(i))!=-1)counter--;
            else{ counter++;}
            if(map.containsKey(counter)){
                large = Math.max(large,i-map.get(counter));
            }
            else{
                map.put(counter,i);
            }

        }
        System.out.print(large);
        sc.close();
    }
}

