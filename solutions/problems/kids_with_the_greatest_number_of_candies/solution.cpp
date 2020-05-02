class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        
        int greatestInArray = *max_element(candies.begin(), candies.end());
        
        int n = candies.size();
        vector<bool> greatestIndicator(n, 0);
        
        for(int i = 0; i < n; i++) {
            greatestIndicator[i] = (candies[i] + extraCandies >= greatestInArray);
        }
        
        return greatestIndicator;
    }
};