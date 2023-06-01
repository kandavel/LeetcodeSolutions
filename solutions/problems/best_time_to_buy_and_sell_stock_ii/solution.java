class Solution {
    public int maxProfit(int[] prices) {
        int maxSoFar = -1;
        int minSoFar = 30001;
        
        int profitSoFar = 0;
        int today = 0;
        while (today < prices.length) {
            while (today < prices.length && prices[today] < minSoFar) {
                minSoFar = prices[today];
                today++;
            }
            
            maxSoFar = minSoFar;
            while (today < prices.length && prices[today] > maxSoFar) {
                maxSoFar = prices[today];
                today++;
            }
            
            // Sold the held stocks
            profitSoFar += maxSoFar - minSoFar;
            
            // Starting from scratch, reset the prev local minima as a new minima to be found now in the rest of the days
            minSoFar = 30001;
        }
        return profitSoFar;
    }
}