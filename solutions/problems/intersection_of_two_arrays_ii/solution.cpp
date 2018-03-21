class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        /*
        int max1=0, max2=0;
        
        for(int i=0;i<nums1.size();i++)
        {
            max1=max(max1, nums1[i]);
        }
        
        for(int i=0;i<nums2.size();i++)
        {
            max2=max(max2, nums2[i]);
        }
        
        vector<int> f1(max1);
        vector<int> f2(max2);
        
        for(int i=0;i<nums1.size();i++)
        {
            f1[nums1[i]]++;
        }
        
        for(int i=0;i<nums2.size();i++)
            f2[nums2[i]]++;
        */
        
        vector<int> sol;
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int i=0,j=0;
        
        while(i<nums1.size() && j<nums2.size())
        {
            if(nums1[i]<nums2[j])
            {
                i++;
            }
            else if(nums1[i]==nums2[j])
            {
                sol.push_back(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j])
            {
             j++;   
            }
        }
             
        return sol;
    }
};