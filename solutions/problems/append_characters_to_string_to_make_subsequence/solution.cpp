class Solution {
public:
    int appendCharacters(string s, string t) {
        int sPtr = 0; 
        int tPtr = 0;

        while(sPtr < s.length() && tPtr < t.length()){
            if (t[tPtr] == s[sPtr])
            tPtr++;

            sPtr++;
        }
        return t.length()-tPtr;
    }
};