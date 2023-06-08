class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ct = 0;
        for(int i = 0; i < m; i++) {
            int l = 0, r = n - 1;

            while (l <= r) {
                int mid = l + (r-l)/2;
                if (grid[i][mid] < 0) 
                    r = mid - 1;
                else if (grid[i][mid] >= 0)
                    l = mid + 1;
            }
            ct += ((l < n)? (n - 1 - r): 0);
        }
        return ct;
    }
}