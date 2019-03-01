class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        
        int n = nums.size();
        
        vector<int> nge(n, 0);
        
        stack<int> s;
        
        for(int i=0;i<n;i++)
        {
            while(!s.empty() && nums[i] > nums[s.top()])
            {
                int j = s.top();
                s.pop();
                
                nge[j] = nums[i];
            }
            s.push(i);
        }
        
        
        for(int i=0;i<n;i++)
        {
            while(!s.empty() && nums[i] > nums[s.top()])
            {
                int j = s.top();
                s.pop();
                
                nge[j] = nums[i];
            }
        }
        
        while(!s.empty())
        {
            int j = s.top();
            s.pop();
                
            nge[j] = -1;
        }
        
        return nge;
    }
};