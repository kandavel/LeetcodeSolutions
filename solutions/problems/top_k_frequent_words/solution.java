class Solution {
    class ValueKeyComparator implements 
    Comparator<Map.Entry<String, Integer>> {

        public int compare(
            Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {

                if (a.getValue() == b.getValue())
                return a.getKey().compareTo(b.getKey());

                return b.getValue().compareTo(a.getValue());
            }
    };

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String curr = words[i];

            Integer freq = freqMap.get(curr);
            
            if (freq == null)
            freqMap.put(curr, 1);
            else
            freqMap.replace(curr, freq + 1);
        }

        List<Map.Entry<String, Integer>> wordFreqList = 
        new ArrayList<>();

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            wordFreqList.add(entry);
        }

        ValueKeyComparator valueKeyComparator = new ValueKeyComparator();
        Collections.sort(wordFreqList, new ValueKeyComparator());
        
        List<String> topKWords = new ArrayList<>();
        for (int i = 0; i < k; i++)
        topKWords.add(wordFreqList.get(i).getKey());

        return topKWords;
    }
}