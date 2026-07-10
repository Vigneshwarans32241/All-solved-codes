import java.util.*;
public class matrixprefix {
    public static void printmatrix(int[][] matrix){
        int R = matrix.length, C = matrix[0].length;
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
    public static int[][] rowsum(int[][] matrix){
        int R = matrix.length, C = matrix[0].length;
        int[][] sum = new int[R][C];
        for(int i = 0;i<R;i++){
            int sum1 = 0;
            for(int j = 0;j<C;j++){
                sum1+=matrix[i][j];
                sum[i][j] = sum1;

            }
        }
        return sum;
    }
    public static int[][] colsum(int[][] matrix){
        int R = matrix.length, C = matrix[0].length;
        int[][] sum = new int[R][C];
        for(int i = 0;i<C;i++){
            int sum1 = 0;
            for(int j = 0;j<R;j++){
                sum1+=matrix[j][i];
                sum[j][i] = sum1;
            }
        }
        return sum;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(),C = sc.nextInt();
        int[][] matrix = new int[R][C];
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        printmatrix(matrix);
        int[][] rowmatrix = rowsum(matrix);
        printmatrix(rowmatrix);
        int[][] colmatrix = colsum(rowmatrix);
        printmatrix(colmatrix);
    }
}
