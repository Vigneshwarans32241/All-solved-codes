import java.util.*;
public class Main {
    public static int[] OOM(Scanner sc){
        int n=sc.nextInt(),m=sc.nextInt(),h=sc.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++) a[i] = sc.nextInt();
        int[] d = Arrays.copyOf(a, a.length);
        for(int i = 0;i<m;i++){
            int b=sc.nextInt(),c=sc.nextInt();
            if(d[b-1]+c>h) d = Arrays.copyOf(a, a.length);
            else{
                d[b-1] = d[b-1]+c;
            }
        }
        return d;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0;i<t;i++){
            int[] arr = OOM(sc);
            for(int j = 0;j<arr.length;j++){
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }
    }
}
