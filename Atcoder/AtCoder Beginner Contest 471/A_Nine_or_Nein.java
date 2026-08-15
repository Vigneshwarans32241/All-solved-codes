import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int add = A + B;
        int sub = A - B;
        int mul = A * B;
        double div = (double) A / B;
        if (add == 9 || sub == 9 || mul == 9 || div == 9) System.out.println("Nine");
        else System.out.println("Nein");
    }
}
