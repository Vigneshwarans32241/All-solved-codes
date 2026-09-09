import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		int[] pos = new int[N+1];
		List<Integer> arr = new ArrayList<>();
		for(int i = 0;i<N;i++){
			int val = sc.nextInt();
			arr.add(val);
			pos[val] = i;
		}
		int i = 0;
		while(Q-->0){
			int val = sc.nextInt();
			arr.set(pos[val],-1);
			arr.add(val);
			pos[val] = N+i;
			i++;
		}
		for(i = 0;i<arr.size();i++) if(arr.get(i)!=-1) System.out.print(arr.get(i)+" ");
	}
}

