class Solution {
public:
    bool checkIfS2CanBreakS1(string s1, string s2) {
        // cout<<s1<<" "<<s2<<endl;
        sort(s2.begin(), s2.end());
        sort(s1.begin(), s1.end());
        
        int n = s1.size();
        for(int i = 0; i < n; i++) {
            if (s1[i] > s2[i]) {
                return false;
            }
        }
        // cout<<"YES"<<endl;
        return true;
    }
    
    bool checkIfCanBreak(string s1, string s2) {
        
        return (checkIfS2CanBreakS1(s1, s2) || checkIfS2CanBreakS1(s2, s1));
    }
};