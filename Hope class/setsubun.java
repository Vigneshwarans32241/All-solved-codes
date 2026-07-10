import java.util.*;
public class setsubun{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    int count = 0,total = 0;
    while(total<K){
      total+=N;
      count++;
      N+=1;
    }
    System.out.print(count-1);
  }
}