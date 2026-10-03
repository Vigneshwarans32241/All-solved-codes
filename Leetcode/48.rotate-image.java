class Solution {
    public void rotate(int[][] matrix) {
        int R = matrix.length,C = matrix[0].length;
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                if(j>i){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        for(int i = 0;i<R;i++){
            int left = 0,right = C-1;
            while(left<=right){
                int temp = matrix[i][right];
                matrix[i][right] = matrix[i][left];
                matrix[i][left] = temp;
                left++;
                right--;
            }
        }
    }
}
