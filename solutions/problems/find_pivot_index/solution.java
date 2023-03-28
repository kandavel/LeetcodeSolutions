class Solution {
    public int pivotIndex(int[] nums) {
        
        int totSum = 0;
        int runningSumLeftOpen = 0;

        for(int i=0; i<nums.length; i++) {
            totSum += nums[i];
        }

        int pivotIndex = -1;

        for(int i=0; i<nums.length; i++) {
            
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
}