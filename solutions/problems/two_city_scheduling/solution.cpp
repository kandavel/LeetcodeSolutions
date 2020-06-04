class Solution {
public:
    int d[101][101][101] = {0};
    
    int f(vector<vector<int>> costs, int i, int A, int B) {
        
        if (A==0 && B==0) {
            
            d[i][A][B] = 0;
            return d[i][A][B];
        }
        
        if (i==costs.size()) {
            
            d[i][A][B] = 100001;
            return d[i][A][B];
        }
        
        long int takeA=100001, takeB=100001;
        if(A>0) {
            takeA = costs[i][0] + (d[i+1][A-1][B] == 100001? f(costs, i+1, A-1, B): d[i+1][A-1][B]);
        }
        
        if(B>0) {
            takeB = costs[i][1] + (d[i+1][A][B-1] == 100001? f(costs, i+1, A, B-1): d[i+1][A][B-1]);
        }
        
        d[i][A][B] = min(takeA, takeB);
        
        return d[i][A][B];
    }
    
    int twoCitySchedCost(vector<vector<int>>& costs) {
        
        int n = costs.size() / 2;
        
        for(int i=0;i<=100;i++)
        {
            for(int j=0;j<=100;j++) {
                
                for(int k=0;k<=100;k++) {
                    d[i][j][k] = 100001;
                }
            }
        }
        
//         for(int i=0;i<n;i++) {
//             d[i][0][0] = INT_MAX;
//         }
        
//         for(int j=1;j<=n;j++) {

//             for(int k=1;k<=n;k++) {
//                 d[0][j][k] = min();
//             }
//         }
        
//         for(int i=1;i<n;i++)
//         {
//             for(int j=1;j<=n;j++) {
                
//                 for(int k=1;k<=n;k++) {
//                     d[i][j][k] = min(d[i-1])
//                 }
//             }
//         }
        
        return f(costs, 0, n, n);
    }
};