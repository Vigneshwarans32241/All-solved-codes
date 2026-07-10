import java.util.*;
public class footballteamsv2 {
    public static void main(String[] args){
        int n,ans = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[2*n+2];
        for(int i = 0;i<2*n+2;i++){
            int curr = sc.nextInt();
            arr[i] = curr;
            ans^=curr;
        }
        int i = 0;
        System.out.println(ans);
        while((ans&1)==0){
            ans = (ans>>1);
            System.out.println("ans:"+ans);
            i++;
        }
        int shift = 1<<i;
        System.out.println("Shift:"+shift);
        int[] zero = new int[2*n+2];
        int[] one = new int[2*n+2];
        int zeroind = 0;
        int oneind = 0;
        for(i = 0;i<arr.length;i++){
            if((arr[i]&shift)!=0){
                zero[zeroind] = arr[i];
                zeroind++;
            }
            else{
                one[oneind] = arr[i];
                oneind++;
            }
        }
        oneind--;zeroind--;
        int ans1 = 0,ans2 = 0;
        // for(int j = 0;j<zero.length;j++){
        //     System.out.println(zero[j]);
        // }
        // for(int j = 0;j<one.length;j++){
        //     System.out.println(one[j]);
        // }
        while(zeroind>=0){
            ans1^=zero[zeroind];
            zeroind--;
        }
        while(oneind>=0){
            ans2^=one[oneind];
            oneind--;
        }
        System.out.print(ans1+" and "+ans2);
        sc.close();
    }
}
