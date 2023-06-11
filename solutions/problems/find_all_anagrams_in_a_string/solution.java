class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int fp[] = new int[128];
        int uniqueChars = 0;

        for (int i = 0; i < p.length(); i++)
        {
            if (fp[p.charAt(i) - 'a'] == 0)
                uniqueChars++;
            fp[p.charAt(i) - 'a']++;
        }

        int matchingUniqueChars = 0;
        int fs[] = new int[128];

        int l = 0, r = 0;
        List<Integer> matchingIndices = new ArrayList<>();

        while(r < s.length() && r - l + 1 <= p.length()) {
            // System.out.println("l = " + l + ", r = " + r);

            int curr = s.charAt(r) - 'a';
            
            fs[curr]++;
// System.out.println("fs[curr]" + ", " + fs[curr]);
            if (fs[curr] == fp[curr]){
                matchingUniqueChars++;
// System.out.println(matchingUniqueChars + ", " + uniqueChars);
                if (matchingUniqueChars == uniqueChars) {
                    matchingIndices.add(l);

                    // one char in the anagram window is to be shaved 
                    // off to make the next window,
                    // so, matchingChars is reduced by that one char

                    
                }
            }

            if (r-l+1 == p.length()) {
                // slide the window from left to right,
                // l -> l + 1
                // f[char at l] --;
                int charAtBegOfWindow = s.charAt(l) - 'a';

                // char being shaved off is a matching character 
                if (fs[charAtBegOfWindow] == fp[charAtBegOfWindow])
                    matchingUniqueChars--;

                fs[charAtBegOfWindow]--;

                l++;
            } 
            r++;
        }
        return matchingIndices;
    }
}