import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String S = sc.next();
		char[] chars = S.toCharArray();
		int count = 0;
		for(int i = 0;i<chars.length;i++){
			if(chars[i]!='x') continue;
			boolean left = (i==0 || chars[i-1]=='x');
			boolean right = (i==N-1 || chars[i+1]=='x');
			if(left&&right) count++;
		}
		System.out.println(count);
	}
}
