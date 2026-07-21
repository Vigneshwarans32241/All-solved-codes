import java.util.*;
public class A_Obesity{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		float H = sc.nextFloat();
		float W = sc.nextFloat();
		if(W * 10000 >= 25 * H * H) 
			System.out.println("Yes");
		else System.out.println("No");
	}
}
