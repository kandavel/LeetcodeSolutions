class Solution {
    public int largestAltitude(int[] gain) {

        int gainSoFar = 0;
        int maxGain = 0;

        for(int i = 0; i < gain.length; i++) {
            gainSoFar += gain[i];
            maxGain = Math.max(maxGain, gainSoFar);
        }
        return maxGain;
    }
}