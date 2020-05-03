class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int F[256] = {0};
        
        for(int i=0;i<magazine.length(); i++) {
            F[magazine[i]]++;
        }
        
        for(int i=0;i<ransomNote.length(); i++) {
            
            if(F[ransomNote[i]] == 0) {
                return 0;
            }
            
            F[ransomNote[i]]--;
        }
        return 1;
    }
};