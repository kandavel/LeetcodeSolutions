class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] addendums = new int[2];
        HashMap<Integer, Integer> isPresent = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            int addendum = target - nums[i];
            
            Integer indexOfAddendum = isPresent.get(addendum);
            if (indexOfAddendum != null) {
                addendums[0] = indexOfAddendum;
                addendums[1] = i;
                break;
            }
                
            isPresent.put(nums[i], i);
        }
        return addendums;
    }
}