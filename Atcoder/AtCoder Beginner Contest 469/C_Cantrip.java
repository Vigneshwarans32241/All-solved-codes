import java.util.*;
class C_Cantrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String S = sc.next();
        char[] chars = S.toCharArray();
        int[] prefixO = new int[N + 1];
        int[] prefixX = new int[N + 1];
        for(int i = 0;i<N;i++){
            prefixO[i+1] = prefixO[i]+(chars[i]=='o'?1:0);
            prefixX[i+1] = prefixX[i]+(chars[i]=='x'?1:0);
        }
        ArrayList<Integer> xpos = new ArrayList<>();
        for(int i = 0;i<N;i++){
            if(chars[i]=='x') xpos.add(i);
        }
        for(int i = 1;i<=N;i++){
            int tokens = prefixO[i];
            if(tokens==0){
                System.out.println(i);
                continue;
            }
            int xbefore = prefixX[i];
            int target = tokens - 1 + xbefore;
            if(target>=xpos.size()){
                System.out.println(N);
                continue;
            }
            else{
                System.out.println(xpos.get(target)+1);
            }
        }
    }
}