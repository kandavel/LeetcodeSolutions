class Solution {
    public int fib(int n) {
        int d[] = new int[2];

        d[0] = 0;
        d[1] = 1;

        for (int i = 2; i <= n; i++)
        d[i%2] = (d[(i-1)%2] + d[(i-2)%2]);

        return d[(n)%2];
    }
}