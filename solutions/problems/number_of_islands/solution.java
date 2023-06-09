class Solution {
    public boolean isValid(int x, int y, int m, int n) {
        return (x>=0 && x<m) && (y>=0 && y<n);
    }

    public void dfs(int i, int j, char [][]grid, int [][]visited) {
        if (visited[i][j] == 1)
        return;

        visited[i][j] = 1;

        int m = grid.length;
        int n = grid[0].length;

        if (isValid(i, j+1, m, n) && grid[i][j+1] == grid[i][j])
        dfs(i, j+1, grid, visited);

        if (isValid(i+1, j, m, n) && grid[i+1][j] == grid[i][j])
        dfs(i+1, j, grid, visited);

        if (isValid(i, j-1, m, n) && grid[i][j-1] == grid[i][j])
        dfs(i, j-1, grid, visited);

        if (isValid(i-1, j, m, n) && grid[i-1][j] == grid[i][j])
        dfs(i-1, j, grid, visited);
    }

    public int numIslands(char[][] grid) {
        int ct = 0;

        int m = grid.length;
        int n = grid[0].length;

        int visited[][] = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if (grid[i][j] == '1' && visited[i][j] == 0){
                    ct++;

                    dfs(i, j, grid, visited);
                }
            }
        }
        return ct;
    }
}