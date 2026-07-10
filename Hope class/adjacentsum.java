public class adjacentsum {
    public static int[][] summing(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                int sum = 0;
                for(int d = 0;d<8;d++){
                    int ni = i+dx[d];
                    int nj = j+dy[d];
                    if(ni>=0 && ni<rows && nj>=0 && nj<cols){
                        sum+=matrix[ni][nj];
                    }
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] result = summing(matrix);
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<result[0].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
