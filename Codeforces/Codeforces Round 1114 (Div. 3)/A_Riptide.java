import java.util.*;
public class A_Riptide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int[] arr = new int[3];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();
            int rounds = 0;
            while (true) {
                if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) break;
                int max = 0, min = 0;
                for (int i = 1; i < 3; i++) {
                    if (arr[i] > arr[max]) max = i;
                    if (arr[i] < arr[min]) min = i;
                }
                arr[max]--;
                arr[min]++;
                rounds++;
            }
            System.out.println(rounds);
        }
    }
}