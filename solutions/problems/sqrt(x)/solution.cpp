class Solution {
public:
    int mySqrt(int x) {
        
        int l = 1, r = x;
        
        while(l<=r) {
            
            long long int mid = l + (r-l)/2;
            long long int square = (mid*mid);
            
            if (square == x) {
                return mid;
            } else if (square < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
};