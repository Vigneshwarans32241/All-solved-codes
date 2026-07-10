import java.util.Scanner;
import java.util.Stack;

public class immmax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int index = 0;index<N;index++){
            arr[index] = sc.nextInt();
        }
        int[] res = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int index = N-1;index>=0;index--){
            while(!stack.isEmpty() && stack.peek()<=arr[index]) stack.pop();
            res[index] = stack.isEmpty()? -1 : stack.peek();
            stack.push(arr[index]);
        }
        for(int i = 0;i<N;i++){
            System.out.println( res[i]+" ");
        }
    }
}
