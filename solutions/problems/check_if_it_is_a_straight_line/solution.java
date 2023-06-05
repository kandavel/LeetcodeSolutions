class Solution {
    public int areaOfTriangle(int i, int[][] coordinates) {
        int x1 = coordinates[i-2][0];
        int y1 = coordinates[i-2][1];

        int x2 = coordinates[i-1][0];
        int y2 = coordinates[i-1][1];

        int x3 = coordinates[i][0];
        int y3 = coordinates[i][1];

        return (x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)) ;
    }

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2)
        return true;

        int n = coordinates.length;
        int deltaX = coordinates[1][0] - coordinates[0][0];
        int deltaY = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < n; i++) {
            if(areaOfTriangle(i, coordinates) != 0)
            return false;
        }
        return true;
    }
}