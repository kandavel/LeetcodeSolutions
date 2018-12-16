class Solution {
public:
    void construct(string &A)
{
    string t="";
    int n = A.length();
    
    for(int i=0;i<n;i++)
    {
        t += '$';
        t += A[i];
    }
    t += '$';
    
    A = t;
}

string longestPalindrome(string A) {
    
    construct(A);
    
    int n = A.length();
    vector<int> P(n, 0);
    
    int C=0, R = 0;
    int maxp = 0;
    
    for(int i=1;i<n-1;i++)
    {
       // cout<<i<<" "<<R<<" "<<P[i]<<" "<<C;
        if(i < R)
        {
            int mirror = C - (i-C);
            P[i] = min(P[mirror], R - i);
        }
        
        while(i-P[i]-1>=0 && i+P[i]+1<n && A[i + P[i] + 1] == A[i - P[i] - 1])
        P[i]++;
        
        if(i + P[i] > R)
        {
            R = i + P[i];
            C = i;
        }
        
        if(P[i] > P[maxp])
            maxp = i;
            
       // cout<<"|"<<" "<<R<<" "<<P[i]<<" "<<C<<endl;
    }
    
    int l = maxp - P[maxp] + 1, r = maxp + P[maxp] - 1;
    int i = l;
  //  cout<<maxp<<" "<<P[maxp];
    string substr="";
    
    while(i <= r)
    {
        substr += A[i];
        i = i+2;
    }
    
    return substr;
}

    
};