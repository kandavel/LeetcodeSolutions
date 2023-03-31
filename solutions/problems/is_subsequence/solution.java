class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
        return false;

        int sPtr = 0, tPtr = 0;

        while(sPtr < s.length() && tPtr < t.length()) {
            if (s.charAt(sPtr) == t.charAt(tPtr))
                sPtr++;
            
            tPtr++;
        }
        return sPtr == s.length();
    }
}