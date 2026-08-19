class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, boolean[]> rows = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            rows.putIfAbsent(row, new boolean[11]);
            rows.get(row)[seat[1]] = true;
        }
        int count = (n - rows.size()) * 2;
        for (boolean[] seats : rows.values()) {
            boolean left = true;
            boolean middle = true;
            boolean right = true;
            for (int i = 2; i <= 5; i++) {
                if (seats[i]) {
                    left = false;
                    break;
                }
            }
            for (int i = 4; i <= 7; i++) {
                if (seats[i]) {
                    middle = false;
                    break;
                }
            }
            for (int i = 6; i <= 9; i++) {
                if (seats[i]) {
                    right = false;
                    break;
                }
            }
            if (left && right) count += 2;
            else if (left || middle || right) count += 1;
        }
        return count;
    }
}
