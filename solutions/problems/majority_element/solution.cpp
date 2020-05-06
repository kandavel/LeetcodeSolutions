class Solution {
public:
    int majorityElement(vector<int>& nums) {
        // 1 3 2 2 2 2
        
        int freqMajEmt = 1;
        int majEmt = nums[0];
        
        for(int i=1;i<nums.size();i++) {
            
            if(nums[i] == majEmt) {
                freqMajEmt++;
                continue;
            }
            
            freqMajEmt--;

            if(freqMajEmt == 0) {
                majEmt = nums[i];
                freqMajEmt = 1;
            }
        }
        return majEmt;
    }
};