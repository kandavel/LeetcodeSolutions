class Solution {
    long mod = (long) 1e9 + 7;
    long nCr[][];

    public void computeCombinations(int m) {
        // Pascal Triangle table
        nCr = new long[m][m];

        for (int i = 0; i < m; i++){
            nCr[i][0] = 1;
            nCr[0][i] = 1;
            nCr[i][i] = 1;
        }

        for (int n = 2; n < m; n++) {
            for (int r = 1; r < n; r++) {
                nCr[n][r] = (nCr[n - 1][r] + nCr[n - 1][r - 1]) % mod;
            }
        }
    }

    public long numOfWaysUtil(ArrayList<Integer> nodes) {
        int n = nodes.size();
        if (n == 0 || n == 1 || n == 2)
        return 1;

        int root = nodes.get(0);

        ArrayList<Integer> leftST = new ArrayList<>();
        ArrayList<Integer> rightST = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int node = nodes.get(i);
            if (node > root){
                rightST.add(node);
            }
            else {
                leftST.add(node);
            }
        }

        long numOfLeftSTRelativeCombinations = numOfWaysUtil(leftST);
        long numOfRightSTRelativeCombinations = numOfWaysUtil(rightST);

        long numOfLeftRightSTRelativeCombinations =
        (long) (numOfLeftSTRelativeCombinations * numOfRightSTRelativeCombinations) % mod;


        int numOfNodesInLeftST = leftST.size();
        int numOfNodesInRightST = rightST.size();

        int totPlacesToBeChosen = n - 1;

        return (int) (((long)
        nCr[totPlacesToBeChosen][numOfNodesInLeftST] * numOfLeftRightSTRelativeCombinations) % mod);
    }

    public int numOfWays(int[] nums) { 
        int n = nums.length;
        computeCombinations(n);

        ArrayList<Integer> numsVarList = new ArrayList<>(n);
        for(int i = 0; i < n; i++)
        numsVarList.add(nums[i]);

        return (int) numOfWaysUtil(numsVarList) - 1;
        
    }
}