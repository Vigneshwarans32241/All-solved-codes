import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] P = new int[N];
		for(int i = 0;i<N;i++) P[i] = sc.nextInt();
		for(int i = 0;i<N;i+=10){
			List<Integer> mem = new ArrayList<>();
			for(int j = i;j<Math.min(i+10,N);j++){
				if(P[j]>Math.min(i+10,N)){
					System.out.println("No");
					return;
				}
			}
		}
		System.out.println("Yes");
	}
}
