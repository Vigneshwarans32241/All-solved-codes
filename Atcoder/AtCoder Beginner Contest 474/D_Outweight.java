import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		for(int i = 0;i<N;i++) A[i] = sc.nextInt();
		for(int i = 0;i<N;i++) B[i] = sc.nextInt();
		long am = 0,bm = 0;
		for(int i = 0;i<N;i++){
			if(A[i]>B[i]) am+=A[i]-B[i];
			else if(B[i]>A[i]) bm+=B[i]-A[i];
		}
		if(am==0){
			System.out.println("No");
			return;
		}
		long weight = (bm/am)+2;
		List<Long> ans = new ArrayList<>();
		for(int i = 0;i<N;i++){
			if(A[i]<=B[i]) ans.add(1L);
			else ans.add(weight);
		}
		System.out.println("Yes");
		for(long wt : ans) System.out.print(wt+" ");
	}
}

