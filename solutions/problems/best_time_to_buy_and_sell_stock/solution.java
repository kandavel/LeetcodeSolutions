class Solution {
    public int maxProfit(int[] prices) {

        int maxProfitSoFar = 0;
        int minSoFar = 10001;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            }

            maxProfitSoFar = Math.max(maxProfitSoFar, prices[i] - minSoFar);
        }
        return maxProfitSoFar;
        
    }
}