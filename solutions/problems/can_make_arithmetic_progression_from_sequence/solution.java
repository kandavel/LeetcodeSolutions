class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        HashMap<Integer, Boolean> isPresent = new HashMap<>();
        int n = arr.length;

        int begOfAP = 1000006;
        int second = 1000006;
        for (int i = 0; i < n; i++) {
            isPresent.put(arr[i], true);

            if (arr[i] < begOfAP) {
                second = begOfAP;
                begOfAP = arr[i];
            } else if (arr[i] < second) {
                second = arr[i];
            }
        }

        int d = second - begOfAP;
        int dCurr = 0;

        int ct = 0;
        for (int i = 0; i < n; i++) {
            if (isPresent.get(begOfAP + dCurr) == null)
                return false;

            if (d == 0) {
                // maintain count of elements with the equal value
                if(arr[i] == begOfAP)
                ct++;
            }
            dCurr += d;
        }
        if (d == 0)
        return ct == n;

        return true;
    }
}