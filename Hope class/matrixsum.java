import java.util.*;
public class matrixsum {
    public static int ones(int[] arr){
        int sum = 0,j = 0,maxsum = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]!=0){
                sum+=arr[i];                if(sum>maxsum) maxsum = sum;

            }
            else{
                sum = 0;
            }
        }   
        return maxsum;
    }
    public static void main(String[] args){
        int[][] matrix = new int[5][6];
        Scanner sc = new Scanner(System.in);
        int max = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                matrix[i][j] = sc.nextInt();
            }
            max = Math.max(max,ones(matrix[i]));
        }
        System.out.print(max);
    }
}
