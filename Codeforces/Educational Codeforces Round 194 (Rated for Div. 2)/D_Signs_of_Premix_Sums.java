import java.util.*;
class Main{
	private static void solve(Scanner sc){
		int N = sc.nextInt();
		String s = sc.next();
		if(s.charAt(0)=='0' || s.contains("00")){
			System.out.println(-1);
			return;
		}
		int ans = -1;
		if(s.contains("+-") || s.contains("-+")){
			if(s.contains("+--+") || s.contains("-++-")) ans = 3;
			else ans = 2;
		}
		else{
			ans = 1;
			for(int i = 0;i<N;i+=2) {
				if(s.charAt(i)=='0'){
					ans = 2;
					break;
				}
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) solve(sc);
	}
}
		
