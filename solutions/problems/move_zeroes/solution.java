class Solution {
    public void moveZeroes(int[] nums) {
        
        int lastZeroPos = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
               if (lastZeroPos == -1)
                   lastZeroPos = i;
           } else {
            if(lastZeroPos != -1 ) {
               nums[lastZeroPos] = nums[i];
               nums[i] = 0;
               lastZeroPos++;
           }
        }
        }
    }
}