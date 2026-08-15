import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    for(int i = 0;i<N;i++) arr[i] = sc.nextInt();
    ArrayList<Integer> neg = new ArrayList<>();
    ArrayList<Integer> pos = new ArrayList<>();
    for(int x : arr){
      if(x<0) neg.add(x);
      else pos.add(x);
    }
    Collections.sort(neg,Collections.reverseOrder());
    Collections.sort(pos);
    int i = 0;
    int j = 0;
    long ans = 0,current = 0;
    while(i < neg.size() || j < pos.size()) {
        if(i == neg.size()){
            ans += Math.abs(pos.get(j) - current);
            current = pos.get(j);
            j++;
            continue;
        }
        if(j == pos.size()){
            ans += Math.abs(neg.get(i) - current);
            current = neg.get(i);
            i++;
            continue;
        }
        long negpos = Math.abs(neg.get(i) - current);
        long pospos = Math.abs(pos.get(j) - current);
        if(negpos <= pospos){
            ans += negpos;
            current = neg.get(i);
            i++;
        }
        else{
            ans += pospos;
            current = pos.get(j);
            j++;
        }
    }
    System.out.println(ans);
  }
}
