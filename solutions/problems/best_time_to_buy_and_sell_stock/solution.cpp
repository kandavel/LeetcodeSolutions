class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int maxS = 0;
        int maxP = 0;
        int n = prices.size();
        
        for(int i=n-1;i>=0;i--)
        {
            maxS = max(maxS, prices[i]);
            
            maxP = max(maxP, maxS-prices[i]);
        }
        return maxP;
    }
};