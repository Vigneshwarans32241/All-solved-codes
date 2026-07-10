import java.util.*;

public class flip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for(int val = 0;val<n;val++){
                arr.add(sc.nextInt());
            }
            int spl = sc.nextInt();
            int splindex = arr.get(spl-1);
            arr.add(0,splindex);arr.add(arr.size(),splindex);
            spl++;
            int[] dpL = new int[arr.size()];
            int[] dpR = new int[arr.size()];
            for(int index = 1;index<=spl;index++){
                if(arr.get(index).equals(arr.get(index-1))) dpL[index] = dpL[index-1]+1;
                else dpL[index]=dpL[index-1];
            }
            for(int index = arr.size()-2;index>=spl;index--){
                if(arr.get(index).equals(arr.get(index+1))) dpR[index] = dpR[index+1]+1;
                else dpR[index] = dpR[index+1];
            }
            System.out.println("Ans:"+Math.max(dpL[spl-1],dpR[spl+1]));
        }
    }
}
