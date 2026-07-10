import java.util.*;
public class alphabet {
    public static void main(String args[]){
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        // char[] str = s.toCharArray();
        // Set<Character> set = new HashSet<>();
        // for(char c : str){
        //     set.add(c);
        // }
        // if(set.size()==26) System.out.print("yes");
        // else System.out.print("no");
        int flag = 0;
        for(char c : s.toLowerCase().toCharArray()){
            if(c>='a' && c<='z'){
                int bit = c-'a';
                flag |= (1<<bit);
            }
        }
        if(flag==((1<<26)-1)) System.out.print("yes");
        else System.out.print("no");
        sc.close();
    }
}
