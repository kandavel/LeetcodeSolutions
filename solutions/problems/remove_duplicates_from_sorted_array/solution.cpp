class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
       int i=0, j=1;
        
        if(nums.empty())
            return 0;
        
        int n=nums.size();
        
        while(i<n && j<n)
        {
            if(nums[j]==nums[i])
                j++;
            else 
            {
                i++;
                nums[i]=nums[j];
            }
        }
        
        return i+1;
    }
};