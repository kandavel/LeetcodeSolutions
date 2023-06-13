class Solution {
    public void updateFreq(HashMap<String, Integer> freqMap, String key) {
        if (freqMap.isEmpty()) {
            freqMap.put(key, 1);
        }
        else {
            Integer freq = freqMap.get(key);

            if (freq == null)
            freqMap.put(key, 1);
            else freqMap.replace(key, freq + 1);
        }
    }

    public int pairFreq(HashMap<String, Integer> freqMapA, 
    HashMap<String, Integer> freqMapB) {

        int matchingPairs = 0;

        if (freqMapA.isEmpty() || freqMapB.isEmpty())
        return 0;

        for (String currElements : freqMapA.keySet()) {

            Integer currElementsFreqInFirstMap = freqMapA.get(currElements);
            Integer currElementsFreqInSecondMap = freqMapB.get(currElements);

            if (currElementsFreqInSecondMap != null)
            matchingPairs += currElementsFreqInFirstMap * currElementsFreqInSecondMap;
        }
        return matchingPairs;
    }

    public int equalPairs(int[][] grid) {
        int n = grid.length;

        HashMap<String, Integer> rowElements = new HashMap<>();
        HashMap<String, Integer> colElements = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String currRow = "", currCol = "";
            for (int j = 0; j < n; j++) {
                // i-th row
                currRow += ", " + grid[i][j];

                // i-th col
                currCol += ", " + grid[j][i];
            }
            updateFreq(rowElements, currRow);
            updateFreq(colElements, currCol);
        }

        return pairFreq(rowElements, colElements);
    }
}