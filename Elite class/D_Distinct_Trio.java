import java.util.*;
public class D_Distinct_Trio{
  static long c2(long n){
    if(n<2) return 0;
    return n*(n-1)/2;
  }
  static long c3(long n){
    if(n<3) return 0;
    return n*(n-1)*(n-2)/6;
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    HashMap<Integer,Integer> freq = new HashMap<>();
    for(int i = 0;i<N;i++){
      int temp = sc.nextInt();
      freq.put(temp,freq.getOrDefault(temp,0)+1);
    }
    long total = c3(N);
    long invalid = 0;
    for(int f : freq.values()){
      invalid +=c2(f)*(N-(long)f);
      invalid += c3(f);
    }
    System.out.println(total-invalid);
    
  }
}