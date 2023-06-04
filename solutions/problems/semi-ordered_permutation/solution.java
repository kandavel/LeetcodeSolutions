class Solution {
    public int semiOrderedPermutation(int[] nums) {
        
        int pos1 = -1, posN = -1;
        
        int N = nums.length;
        for(int i = 0; i < N; i++) {
            if (nums[i] == 1)
                pos1 = i;
            else if (nums[i] == N)
                posN = i;
        }
        
        if (posN < pos1)
            pos1--;
        
        return (pos1 - 0) + (N - 1 - posN);
        
    }
}