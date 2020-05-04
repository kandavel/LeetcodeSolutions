class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        
        int n = nums.size();
        
        if (n == 0 || n == 1) {
            return n;
        }
        
        deque<int> dec, inc;
        
        int l = 0, r = 0;
        int maxl = 0;
        
        while(l <= r && r < n) {
            
            while(!dec.empty() && nums[dec.back()] <= nums[r]) {
                dec.pop_back();
            }
            // if(dec.empty() || dec.back() != r)
            dec.push_back(r);
            
            
            while(!inc.empty() && nums[inc.back()] >= nums[r]) {
                inc.pop_back();
            }
            // if(inc.empty() || inc.back() != r)
            inc.push_back(r);
            
            int localMaxima = nums[dec.front()];
            int localMinima = nums[inc.front()];
            
            int diff = localMaxima - localMinima;
            
            // cout<<"("<<l<<","<<r<<")"<<endl;
            
            // cout<<localMaxima<<" "<<localMinima<<endl;
            
            if(diff <= limit) {
                maxl = max(maxl, r-l+1);
                r++;
            } else {
                l++;
                
                if(dec.front() < l) {
                    dec.pop_front();
                }
                
                if(inc.front() < l) {
                    inc.pop_front();
                }
                // cout<<"inc.front()"<<" "<<inc.front()<<endl;
                // l++;
            }
            // cout<<maxl<<endl<<endl;
        }
        return maxl;
    }
};