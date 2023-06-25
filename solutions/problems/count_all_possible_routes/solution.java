class Solution {
    int D[][] = new int[100][201];
    long mod = (int)1e9 + 7;
    int ct = 0;

    public void initDP() {
        for (int []arr : D) {
            Arrays.fill(arr, -1);
        }
    }

    public int countRoutesUtil(int []locations, int from, int finish, int fuel) {

        ct = 0;

        if (from == finish) {
            ct++;
            // D[from][fuel] += 1;
        }

        if (fuel == 0) {
            return ct;
        }

        if (D[from][fuel] != -1)
        return D[from][fuel];

        int n = locations.length;
        int pos = locations[from];

        for (int j = 0; j < n; j++) {
            if (j == from)
            continue;

            int d = Math.abs(pos - locations[j]);
            if (d <= fuel)
            ct = (int)(((long) ct + (long) countRoutesUtil(locations, j, finish, fuel - d)) % mod);
        }
        D[from][fuel] = ct;
        return D[from][fuel];
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        initDP();
        return countRoutesUtil(locations, start, finish, fuel);
    }
}