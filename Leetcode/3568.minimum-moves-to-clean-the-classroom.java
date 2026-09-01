class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int sr = 0, sc = 0, litter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    litter++;
                }
            }
        }
        int[][] id = new int[m][n];
        for (int[] row : id) java.util.Arrays.fill(row, -1);
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'L') id[i][j] = idx++;
            }
        }
        int full = (1 << litter) - 1;
        boolean[][][][] visited = new boolean[m][n][1 << litter][energy + 1];
        java.util.ArrayDeque<int[]> q = new java.util.ArrayDeque<>();
        q.offer(new int[]{sr, sc, energy, 0, 0});
        visited[sr][sc][0][energy] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], e = cur[2], mask = cur[3], moves = cur[4];
            if (mask == full) return moves;
            if (e == 0) continue;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || classroom[nr].charAt(nc) == 'X') continue;
                int ne = e - 1;
                if (classroom[nr].charAt(nc) == 'R') ne = energy;
                int nm = mask;
                if (classroom[nr].charAt(nc) == 'L') nm |= 1 << id[nr][nc];
                if (!visited[nr][nc][nm][ne]) {
                    visited[nr][nc][nm][ne] = true;
                    q.offer(new int[]{nr, nc, ne, nm, moves + 1});
                }
            }
        }
        return -1;
    }
}
