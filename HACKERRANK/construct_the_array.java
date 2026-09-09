import java.util.*;
class Main{
	static final long MOD = 1000000007L;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int x = sc.nextInt();
		long same = 1;
		long other = 0;
		for(int i = 2;i<=n;i++){
			long newsame = (other*(k-1))%MOD;
			long newother = (same+other*(k-2))%MOD;
			same = newsame;
			other = newother;
		}
		if(x==1) System.out.println(same);
		else System.out.println(other);
	}
}
