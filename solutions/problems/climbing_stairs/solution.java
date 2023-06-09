class Solution {
    public int climbStairs(int n) {
        int d[] = new int[2];

        d[0] = 1;
        d[1] = 2;

        for (int i = 2; i < n; i++){
            d[i%2] = d[(i-1)%2] + d[(i-2)%2];
        }
        return d[(n-1)%2];
    }
}