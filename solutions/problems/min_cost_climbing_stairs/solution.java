class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int d[] = new int[2];
        int n = cost.length;

        d[0] = 0;
        d[1] = 0;

        for(int i = 2; i <= n; i++) {
            d[i%2] = Math.min(d[(i-1)%2] + cost[i-1], d[(i-2)%2] + cost[i-2]);
        }
        return d[(n)%2];
    }
}