class Solution {
public:
    int firstUniqChar(string s) {
        
        int F[256] = {0};
        
        for(int i = 0;i<s.length();i++) {
            F[s[i]]++;
        }
        
        for(int i=0;i<s.length(); i++) {
            if(F[s[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
};