class Solution {
public:
    int pivotIndex(vector<int>& nums) {

        int totSum = 0;
        int runningSumLeftOpen = 0;

        for(int i=0; i<nums.size(); i++) {
            totSum += nums[i];
        }

        int pivotIndex = -1;

        for(int i=0; i<nums.size(); i++) {
            
            int runningSumLeftClosed = runningSumLeftOpen + nums[i];
            int runningSumRight = totSum - runningSumLeftClosed;

            if (runningSumLeftOpen == runningSumRight) {
                pivotIndex = i;
                break;
            }
            runningSumLeftOpen = runningSumLeftClosed;
        }
        return pivotIndex;        
    }
};