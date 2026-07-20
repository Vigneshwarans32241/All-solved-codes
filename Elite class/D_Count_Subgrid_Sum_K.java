import java.util.*;
public class D_Count_Subgrid_Sum_K{
    public static void main(String[] args) {
        int R,C,K;
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        int[][] grid = new int[R+1][C+1];
        for(int row = 1;row<=R;row++){
            String s = sc.next();
            for(int col = 1;col<=C;col++)
                grid[row][col] = s.charAt(col-1)-'0';

        }
        
        for(int row = 1;row<=R;row++){
            for(int col = 2;col<=C;col++){
                grid[row][col]+=grid[row][col-1];
            }
        }
        for(int col = 1;col<=C;col++){
            for(int row = 2;row<=R;row++){
                grid[row][col]+=grid[row-1][col];
            }
        }
        // for(int row = 1;row<=R;row++){
        //     for(int col = 1;col<=C;col++){
        //         System.out.print(grid[row][col]+" ");
        //     }
        //     System.out.println();
        // }
        int count = 0;
        for(int row = 1;row<=R;row++){
            for(int col = 1;col<=C;col++){
                for(int topR = row;topR<=R;topR++){
                    for(int topC = col;topC<=C;topC++){
                        int sum = grid[topR][topC]-grid[row-1][topC]-grid[topR][col-1]+grid[row-1][col-1];
                        if(sum==K) count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}