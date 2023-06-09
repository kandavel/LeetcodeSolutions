class Solution {
    public void getLongestPrefixSuffix(String s, int l[]) {
        l[0] = 1;
        
        // s = "aaabaaa"
        // s(0,0) = "a"
        // l[0][0] = 1
        // s(0,1) = "aa"
        // l[0][1] = "aa"
        // s(0, 2) = "aaa"
        // l[0][2] = "aaa" = 3
        // s(0, 4) = "aaab"
        // l[0][4] = b;
        
        // haystack = "aaaxaaaaabaaa"
        //             aaab
        //             shift left ptr by how many chars?
        // if the beginning cgars are equal to the eding chars
        // shift left ptr by those many chars
        
        // leftPtr += longestPrefixThatsAlsoSuffix at i where haystack(i) =/= string(j)
        
        int runningMatchingChars = 0;
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(runningMatchingChars))
                runningMatchingChars++;
            else
                runningMatchingChars = 0;
            
            l[i++] = runningMatchingChars;
        }
    }
    
    public int strStr(String haystack, String needle) {
        
        int n = needle.length();
        int longestPrefixThatsAlsoSuffix[] = new int[n];
        
        getLongestPrefixSuffix(needle, longestPrefixThatsAlsoSuffix);
        
        int i = 0, j = 0;
        while(i < haystack.length() && j < n) {
            if (haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
            } else {
                if (j == 0)
                    i++;
                else {
                    i -= j;
                    
                    int wasteChars = Math.max(1, longestPrefixThatsAlsoSuffix[j]);
                    i += wasteChars;
                    j = 0;
                }
            }
        }
        if (j == n)
            return i - n;
        else 
            return -1;
    }
}