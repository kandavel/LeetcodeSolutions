class Solution {
public:
    
    int minPossible(int pos) {
        
        if (pos == 0) {
            return 1;
        }
        
        return 0;
    }
    
    int maxDiff(int num) {
        
        vector<int> digits;
        
        int temp = num;
        while(temp) {
            digits.push_back(temp%10);
            temp /= 10;
        }
        
        reverse(digits.begin(), digits.end());
        
        vector<int> a(digits);
        
        int numDigits = digits.size();
        
        int key = -1;
        int val = 0;
        
        for(int i = 0; i < numDigits; i++) {
            
            if (key != -1) {
                
                if (a[i] == key) {
                    a[i] = val;
                }
                // cout<<a[i]<<" ";
                continue;
            }
            
            if (a[0] == 1 && a[i] == a[0]) {
                continue;
            }
            
            if(digits[i] > minPossible(i)) {
                
                key = digits[i];
                val = minPossible(i);
                
                a[i] = val;
                
            }
            // cout<<a[i]<<" ";
        }
        
        vector<int> b(digits);
        
        key = -1;
        val = 0;
        
        for(int i = 0; i < numDigits; i++) {
            
            if (key != -1) {
                
                if (b[i] == key) {
                    b[i] = val;
                }
                // cout<<b[i]<<" ";
                continue;
            }
            
            if (b[i] < 9) {
                
                key = b[i];
                val = 9;
                
                b[i] = val;
                
            }
            
            // cout<<b[i]<<" ";
        }
        
        long long int maxDiff = 0;
        long long int placeMultiplier = 1LL;
        
        for(int i = numDigits - 1; i >= 0; i--) {
            
            maxDiff += (b[i] - a[i])*placeMultiplier;
            placeMultiplier *= 10LL;
        }
        // 8808050
        return maxDiff;
    }
};