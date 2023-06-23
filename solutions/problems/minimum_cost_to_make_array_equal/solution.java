class compareOperands implements Comparator<Operand> {
    public int compare(Operand a, Operand b) {
        if (a.val > b.val)
        return 1;
        else if(a.val < b.val)
        return -1;
        else
        return 0;
    }
};

class Operand {
    long val;
    long cost;

    Operand (long val, long cost) {
        this.val = val;
        this.cost = cost;
    }
};

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = cost.length;

        List<Operand> operands = new ArrayList<>();
        for (int i = 0; i < n ; i++)
        operands.add(new Operand((long) nums[i], (long) cost[i]));

        Collections.sort(operands, new compareOperands());

        long dotProductFromLeft[] = new long[n];
        long dotProductFromRight[] = new long[n];
        long prefixCostSum[] = new long[n];
        long suffixCostSum[] = new long[n];

        Operand first = operands.get(0), last = operands.get(n - 1);

        prefixCostSum[0] = first.cost;
        suffixCostSum[n-1] = last.cost;
        dotProductFromLeft[0] = first.cost * first.val;
        dotProductFromRight[n - 1] = last.cost * last.val;

        for (int i = 1; i < n; i++) {
            // System.out.println(operands.get(i).val);
            Operand currFromLeft = operands.get(i);
            Operand currFromRight = operands.get(n - 1 - i);

            prefixCostSum[i] = 
            prefixCostSum[i - 1] + currFromLeft.cost;
            suffixCostSum[n - 1 - i] = 
            suffixCostSum[n - i] + currFromRight.cost;

            dotProductFromLeft[i] = 
            dotProductFromLeft[i - 1] + 
            currFromLeft.cost * currFromLeft.val;

            dotProductFromRight[n - 1 - i] = 
            dotProductFromRight[n - i] + 
            currFromRight.cost * currFromRight.val;
        }

        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Operand curr = operands.get(i);

            long makeAllCurrCostFromRight = 0;

            if (i + 1 < n)
            makeAllCurrCostFromRight =
            dotProductFromRight[i + 1] - suffixCostSum[i + 1] * (long) curr.val;

            long makeAllCurrCostFromLeft = 0;

            if (i >= 1)
            makeAllCurrCostFromLeft = 
            prefixCostSum[i - 1] * curr.val - dotProductFromLeft[i - 1];

            minCost = Math.min(minCost, 
            makeAllCurrCostFromRight + makeAllCurrCostFromLeft);
        }
        return minCost;
    }
}