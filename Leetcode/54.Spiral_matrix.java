import java.util.*;
class Solution {
    private int[] goright(int startr, int startc, boolean[][] visited,int[][] matrix, List<Integer> ans, int C) {
        if (startc >= C || visited[startr][startc])
            return new int[]{startr, startc - 1};
        visited[startr][startc] = true;
        ans.add(matrix[startr][startc]);
        return goright(startr, startc + 1, visited, matrix, ans, C);
    }
    private int[] godown(int startr, int startc, boolean[][] visited,int[][] matrix, List<Integer> ans, int R) {
        if (startr >= R || visited[startr][startc])
            return new int[]{startr - 1, startc};
        visited[startr][startc] = true;
        ans.add(matrix[startr][startc]);
        return godown(startr + 1, startc, visited, matrix, ans, R);
    }
    private int[] goleft(int startr, int startc, boolean[][] visited,int[][] matrix, List<Integer> ans, int C) {
        if (startc < 0 || visited[startr][startc]) return new int[]{startr, startc + 1};
        visited[startr][startc] = true;
        ans.add(matrix[startr][startc]);

        return goleft(startr, startc - 1, visited, matrix, ans, C);
    }
    private int[] goup(int startr, int startc, boolean[][] visited,int[][] matrix, List<Integer> ans, int R) {
        if (startr < 0 || visited[startr][startc]) return new int[]{startr + 1, startc};
        visited[startr][startc] = true;
        ans.add(matrix[startr][startc]);
        return goup(startr - 1, startc, visited, matrix, ans, R);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        boolean[][] visited = new boolean[R][C];
        List<Integer> ans = new ArrayList<>();
        int startr = 0;
        int startc = 0;
        while (ans.size() < R * C) {
            int prev = ans.size();
            int[] pos = goright(startr, startc, visited, matrix, ans, C);
            pos = godown(pos[0] + 1, pos[1], visited, matrix, ans, R);
            pos = goleft(pos[0], pos[1] - 1, visited, matrix, ans, C);
            pos = goup(pos[0] - 1, pos[1], visited, matrix, ans, R);
            startr = pos[0];
            startc = pos[1] + 1;
            if (ans.size() == prev)
                break;
        }
        return ans;
    }
}
