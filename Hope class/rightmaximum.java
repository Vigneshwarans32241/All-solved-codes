import java.util.*;
public class rightmaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            Map<Integer,ArrayList<Integer>> dict = new HashMap<>();
            int n = sc.nextInt(),mdel = n,counter = 0;
            int[] arr = new int[n];
            for(int index = 0;index<n;index++){
                int val = sc.nextInt();
                ArrayList<Integer> list = dict.getOrDefault(val, new ArrayList<Integer>());
                list.add(index);
                dict.put(val,list);
            }
            // for(int index = n;index>0;index--){
            //     if(mdel==0) break;
            //     ArrayList<Integer> val = dict.getOrDefault(index,null);
            //     if(val!=null){
            //         mdel = Math.min(mdel,val.get(val.size()-1));
            //         counter++;
            //     }
                
            // }
            while(mdel>0){
                if(dict.containsKey(mdel)){
                    int key = mdel;
                    ArrayList<Integer> val = dict.get(mdel);
                    int maxIndex = Collections.max(val);
                    mdel = Math.min(mdel,maxIndex);
                    val.remove(Integer.valueOf(maxIndex));
                    counter++;
                    if(val.isEmpty()){
                        dict.remove(key);
                    }
                }
                else{
                    mdel--;
                }
            }
            System.out.println(counter);           
        }
    }
}