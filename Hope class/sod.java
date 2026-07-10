import java.util.*;;
public class sod {
    int[] prefix = new int[900001], ysum = new int[900001], ystr = new int[900001];
    private void populate(){
        for(int ctr = 0;ctr<=900000;ctr++){
            ystr[ctr] = ctr;
            if(ctr==0){
                ysum[ctr] = 0;
            }
            else{
                ysum[ctr] = ctr%9;
                if(ysum[ctr]==0) ysum[ctr] = 9;
            }
            prefix[ctr] = ctr/10;
        }
    }
    private int digitsum(int n){
        if(n==0) return 0;
        return (n%10)+digitsum(n/10);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            
        }
    }
}
