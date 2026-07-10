import java.util.*;
public class palindrome {
    public static void main(String[] args){
        int ans = 0;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            ans^=(1<<(c-'a'));
        }
        if((ans&ans-1)==0 || ans==0){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
        System.out.print(ans);
        sc.close();  
    }
}
