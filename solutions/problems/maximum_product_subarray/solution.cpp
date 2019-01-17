class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxP = 1, minP = 1;
        int n = nums.size();
        
        int maxx=INT_MIN;
        for(int i=0;i<n;i++)
        {
            if(nums[i] ==0)
            {
                maxx = max(maxx, 0);
                minP = 1;
                maxP = 1;
                
                continue;
            }
            
            if(nums[i]<0)
            {
                int temp1 = maxP*nums[i], temp2 = minP*nums[i];
                minP = min(temp1, nums[i]);
                maxP = max(temp2, nums[i]);
            }
            else
            {
                minP = min(minP*nums[i], nums[i]);
                maxP = max(maxP*nums[i], nums[i]);
            }
           // cout<<minP<<" "<<maxP<<endl;
            maxx = max(maxx, maxP);
        }
        return maxx;
    }
};