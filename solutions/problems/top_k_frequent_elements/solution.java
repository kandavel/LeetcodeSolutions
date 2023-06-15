class Solution {
    class ValueComparator implements Comparator<Map.Entry<Integer, Integer>> {
        public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
            return b.getValue().compareTo(a.getValue());
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        List<Map.Entry<Integer, Integer>> numFreqs = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            Integer freq = freqMap.get(curr);

            if (freq == null)
            freqMap.put(curr, 1);
            else
            freqMap.replace(curr, freq + 1);
        }

        for (Map.Entry<Integer, Integer> numFreq : freqMap.entrySet())
        numFreqs.add(numFreq);

        Collections.sort(numFreqs, new ValueComparator());

        // for (int i = 0; i < numFreqs.size(); i++) 
        // System.out.println(numFreqs.get(i).getKey() + ", " + numFreqs.get(i).getValue());

        int []topK = new int[k];
        for (int i = 0; i < k; i++)
        topK[i] = numFreqs.get(i).getKey();

        return topK;
    }
}