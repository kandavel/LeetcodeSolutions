class Solution {
    public boolean isValid(int x, int y, int m, int n) {
        return (x >=0 && x<m) && (y >=0 && y<n);
    }

    public void dfs(int x, int y, int [][]image, int [][]visited, int color) {
        if (visited[x][y] == 1)
        return;

        visited[x][y] = 1;
        if (isValid(x-1, y, visited.length, visited[0].length) && 
        image[x][y] == image [x-1][y])
            dfs(x-1, y, image, visited, color);

        if (isValid(x, y-1, visited.length, visited[0].length) && 
        image[x][y] == image [x][y-1])
            dfs(x, y-1, image, visited, color);

        if (isValid(x+1, y, visited.length, visited[0].length) && 
        image[x][y] == image [x+1][y])
            dfs(x+1, y, image, visited, color);

        if (isValid(x, y+1, visited.length, visited[0].length) && 
        image[x][y] == image [x][y+1])
            dfs(x, y+1, image, visited, color);

        image[x][y] = color;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m = image.length;
        int n = image[0].length;

        int visited[][] = new int[m][n];

        dfs(sr, sc, image, visited, color);

        return image;
    }
}