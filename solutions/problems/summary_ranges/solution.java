class Solution {
    public void pushRange(List<String> ranges, int start, int end) {

        String rangeStr = "" + start;

        if (end != start)
        rangeStr += "->" + end;

        ranges.add(rangeStr);
    }

    public List<String> summaryRanges(int[] nums) {

        List<String> ranges = new ArrayList<>();
        int n = nums.length;

        if (n == 0)
        return ranges;

        int start = nums[0];
        int end = -1;

        boolean rangeOpen = true;

        for (int i = 1; i< n; i++) {

            if ((long) nums[i] - nums[i-1] > (long) 1)
            {
                end = nums[i-1];

                pushRange(ranges, start, end);

                start = nums[i];
                end = -1;
            }
        }
        if (end == -1)
        end = nums[n-1];

        pushRange(ranges, start, end);

        return ranges;
    }
    
}