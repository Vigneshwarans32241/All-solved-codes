import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class foodstamps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        int[] v = new int[n], d = new int[n];
        for(int index = 0;index<n;index++){
            v[index] = sc.nextInt();
        }
        for(int index = 0;index<n;index++){
            d[index] = sc.nextInt();
        }
    }
}
