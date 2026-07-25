import java.util.*;
public class Main{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
int N = sc.nextInt();
int[] arr = new int[N];
for(int i=0;i<N;i++) arr[i] = sc.nextInt();
int count=0;
for(int i=0; i+2<N;i++){
if(arr[i]<arr[i+1] && arr[i+1]>arr[i+2]) count++;
}
System.out.println(count);
}
}
