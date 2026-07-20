import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int idx = (i * n + j - k + total) % total;
                int r = idx / n;
                int c = idx % n;
                row.add(grid[r][c]);
            }
            ans.add(row);
        }

        return ans;
    }
}