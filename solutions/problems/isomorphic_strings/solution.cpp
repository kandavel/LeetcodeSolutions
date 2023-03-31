class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if (s.length() != t.length())
        return false;

        int firstOccurence[256] = {0};
        firstOccurence[s[0]] = 1;

        int charMapS[60000] = {0};

        for (int i = 1; i < s.length(); i++) {
            if(!firstOccurence[s[i]])
            firstOccurence[s[i]] = i+1;
            
            charMapS[i] = firstOccurence[s[i]];
        }

        for (int i = 0; i<256; i++)
        firstOccurence[i] = 0;

        firstOccurence[t[0]] = 1;
        int charMapT[60000] = {0};

        for (int i = 1; i < t.length(); i++) {
            if(!firstOccurence[t[i]])
            firstOccurence[t[i]] = i+1;
            
            charMapT[i] = firstOccurence[t[i]];
        }

        for (int i = 0; i < t.length(); i++) {
            if (charMapS[i] != charMapT[i])
            return false;
        }
        return true;
    }
};