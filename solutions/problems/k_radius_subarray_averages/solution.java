class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long prefixSum[] = new long[n];

        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++)
        prefixSum[i] = prefixSum[i-1] + nums[i];

        int kRadius[] = new int[n];

        if (k > n)
        k = n;

        int i = 0;
        for (; i < k; i++)
        kRadius[i] = -1;

        long denom = (2*k + 1);
        for (; i < n - k; i++) {
            long kBefore = prefixSum[i];

            if (i - k - 1 >= 0)
            kBefore -= prefixSum[i - k - 1];

            long kAfter = prefixSum[i + k] - prefixSum[i];
            kRadius[i] =
             (int)((long) (kBefore + kAfter) / (long) denom); 
        }

        for (; i < n; i++)
        kRadius[i] = -1;

        return kRadius;
    }
}