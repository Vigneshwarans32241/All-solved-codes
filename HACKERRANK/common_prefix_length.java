import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();
		int[] z = new int[n];
		z[0] = n;
		int l = 0,r = 0;
		for(int i = 1;i<n;i++){
			if(i<=r) z[i] = Math.min(r-i+1,z[i-l]);
			while(i+z[i]<n && s.charAt(z[i])==s.charAt(i+z[i])) z[i]++;
			if(i+z[i]-1>r){
				l = i;
				r = i+z[i]-1;
			}
		}
		long ans = 0;
		for(int x : z) ans+=x;
		System.out.println(ans);
	}
}
