class Solution {
public:
    int left(vector<int>& A, int i, int n)
    {
        return ((i-1>=0)?A[i-1]:0);
    }
    
    int right(vector<int>& A, int i, int n)
    {
        return ((i+1 < n)?A[i+1]:0);
    }
    
    int peakIndexInMountainArray(vector<int>& A) {
        
        int n = A.size();
        int l =0, r= n-1;
        
        while(l<=r)
        {
            int mid = (l+r)/2;
            
            int l_ = left(A, mid, n), r_ = right(A, mid, n);
            if(A[mid]>=l_ && A[mid] >=r_ )
                return mid;
            
            if(A[mid]>=l_)
                l = mid+1;
            else if(A[mid] >= r_)
                r = mid-1;            
        }
    }
};