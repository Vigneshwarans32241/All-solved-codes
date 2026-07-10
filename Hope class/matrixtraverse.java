import java.util.Scanner;

public class matrixtraverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(), C = sc.nextInt();
        int[][] grid = new int[R][C];
        for(int row = 0;row<R;row++){
            for(int col = 0;col<C;col++){
                grid[row][col] = sc.nextInt();
            }
        }
        int row = 0,col = 0;
        while(row<R && col<C){
            while(row<R && row>=0 && col<C && col>=0){
                row--;
                col++;
                System.out.print(grid[row][col]+" ");
            }
            while()
        }
    }
}
