import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Map<String,Integer> map = new HashMap<>();
    int N = sc.nextInt();
    int max = 0;
    for(int i = 0;i<N;i++){
      String str = sc.next();
      str = str.toLowerCase();
      map.put(str,map.getOrDefault(str,0)+1);
      max = Math.max(max,map.get(str));
    }
    System.out.println(max);
  }
}
