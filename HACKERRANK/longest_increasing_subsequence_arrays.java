import java.util.*;
class Main{
	static final long MOD = 1000000007L;
	static long power(long a,long b){
		long ans = 1;
		while(b>0){
			if((b&1)==1) ans = ans*a%MOD;
			a = a*a%MOD;
			b>>=1;
		}
		return ans;
	}

	static long inverse(long x) {
		return power(x,MOD-2);
	}

	static long solve(int m,int n){
		long total = power(n,m);
		long bad = 0;
		long comb = 1;
		for(int j = 0;j<n;j++){
			long ways = comb*power(n-1,m-j)%MOD;
			bad = (bad+ways)%MOD;
			if(j+1<n){
				comb = comb*(m-j)%MOD;
				comb = comb*inverse(j+1)%MOD;
			}
		}
		return (total-bad+MOD)%MOD;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		while(P-->0){
			int m = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(solve(m,n));
		}
	}
}
