#include<bits/stdc++.h>

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        
        vector<int> ans;
        deque<int> d;
        int maxe = 0;
        
        if(nums.empty())
            return ans;
        
        for(int i=0;i<k && i<nums.size();i++)
        {
             while(!d.empty() && nums[i]>=nums[d.back()])
                {
                    d.pop_back();
                }
                
                d.push_back(i);
        }
        maxe = nums[d.front()];
        ans.push_back(maxe);
        
        for(int i=k;i<nums.size();i++)
        {            
                while(!d.empty() && nums[i]>=nums[d.back()])
                {
                    d.pop_back();
                }
                
                d.push_back(i);
                
                while(!d.empty() && d.front()+k-1 < i)
                {
                    d.pop_front();
                }
            maxe = nums[d.front()];
        ans.push_back(maxe);
        }
        
        
        
        return ans;
    }
};