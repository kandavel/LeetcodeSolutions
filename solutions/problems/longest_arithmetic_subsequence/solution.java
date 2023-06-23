class Solution {
    public int longestArithSeqLength(int[] nums) {

        // Arrays.sort(nums);
        int n = nums.length;
        int d = 2000;

        int D[][] = new int[n][d+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= d; j++) {
                D[i][j] = 1;
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                int diff = 1000 + (nums[i] - nums[j]);
                D[i][diff] = D[j][diff] + 1;

                maxLen = Math.max(maxLen, D[i][diff]);
                
            }
        }
        return maxLen;
    }
}
