class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        int indeg[1001] = {0};
        int outdeg[1001] = {0};
        
        int judge = -1;
        
        for(int i=0;i<trust.size();i++) {
            int from = trust[i][0];
            int to = trust[i][1];
            
            outdeg[from]++;
            indeg[to]++;
        }
        
        for(int i=1; i<=N; i++) {
            if(indeg[i] == N-1 && outdeg[i] == 0) {
                judge = i;
            }
        }
        return judge;
    }
};