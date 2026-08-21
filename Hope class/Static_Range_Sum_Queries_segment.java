import java.util.*;
public class Static_Range_Sum_Queries_segment {
    static int find(int[] seg,int node,int nl,int nr,int ql,int qr){
        if(nr<ql || nl>qr) return Integer.MAX_VALUE;
        if(nl>=ql && nr<=qr) return seg[node];
        int mid = (nl+nr)/2;
        return Math.min(find(seg,node*2,nl,mid,ql,qr),find(seg,node*2+1,mid+1,nr,ql,qr));
    }
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int Q = sc.nextInt();
    int newN = 1;
    while(newN<N) newN = newN<<1;
    int[] arr = new int[newN*2];
    for(int i = newN;i<newN+N;i++) arr[i] = sc.nextInt();
    for(int i = newN-1;i>0;i--) arr[i] = Math.min(arr[i*2],arr[i*2+1]);
    while(Q-->0){
        int l = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(find(arr,1,0,newN-1,l-1,r-1));
    }
    }
}