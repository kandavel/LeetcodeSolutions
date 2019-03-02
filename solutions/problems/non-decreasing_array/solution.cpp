class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
        
        int n = nums.size();
        
        if(n == 0 || n == 1)
            return 1;

        bool f = 0;
        
        int i = 0, j = n-1;
        
        while(i<n-1 && nums[i] <= nums[i+1])
            i++;
        
        while(j>0 && nums[j] >= nums[j-1])
            j--;
        
        if(j<=i)
            return 1;
        else   
        {          
        if(j == i+1)
        {
            int iB = (i>0)? nums[i-1]: INT_MIN;
            int jA = (j<n-1)? nums[j+1]: INT_MAX;
            
            if(iB <= nums[j] || nums[i] <= jA)
                return 1;
            
            return 0;
        }
        else return 0;
        }
    }
};