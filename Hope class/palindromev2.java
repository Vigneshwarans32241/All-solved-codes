import java.util.*;
public class palindromev2 {
    public static int palindromecheck(String s){
        int xorval = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            xorval^=(1<<(c-'a'));
        }
        return xorval;
    }
    public static void main(String[] args){
        int n,even = 0,odd = 0,grandsum = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Map<Integer,Integer> dict = new HashMap<>();
        String str;
        sc.nextLine();
        for(int i = 0;i<n;i++){
            str = sc.nextLine();
            int xorval = palindromecheck(str);
            if(xorval==0) even++;
            else{
                odd++;
                dict.put(xorval, dict.getOrDefault(xorval, 0)+1);
            }
        }
        grandsum+=(even*(even+1))/2;
        for(Integer i : dict.keySet()){
            int count = dict.get(i);
            grandsum+=(count*(count+1))/2;
        }
        grandsum+=even*odd;
        System.out.print(grandsum);
        sc.close();        
    }
}
