class Solution {
public:
    int findComplement(int num) {
        
        vector<int> v;
        
        int temp = num;
        while(temp) {
            v.push_back(1-temp%2);
            temp /=2;
        }
        
        int multiplier = 1;
        int cmp = 0;
        
        for(int i=0;i<v.size();i++) {
            cmp += multiplier*v[i];
            multiplier <<= 1;
        }
        return cmp;
    }
};