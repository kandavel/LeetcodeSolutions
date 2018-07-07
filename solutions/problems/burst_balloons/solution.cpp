class Solution {
public:
    int maxCoins(vector<int>& nums) {
        if(nums.empty())
            return 0;
        
        int n = nums.size();
        int d[n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            d[i][j] = 0;
        }
        
        for(int s=1;s<=n;s++)
        {
            for(int i=0;i<n-s+1;i++)
            {
                int j=i+s-1;
                for(int k=i;k<=j;k++)
                {
                    int lt = 1, rt = 1;
                    if(i>=1)
                        lt = nums[i-1];
                    if(j<n-1)
                        rt = nums[j+1];
                    
                    int l_arr = 0, r_arr = 0;
                    
                    if(k-1 >= i)
                        l_arr = d[i][k-1];
                    
                    if(k+1 <= j)
                        r_arr = d[k+1][j];
                    
                    d[i][j] = max(d[i][j], l_arr + lt*nums[k]*rt + r_arr);
                }
            }
        }
        return d[0][n-1];
    }
};