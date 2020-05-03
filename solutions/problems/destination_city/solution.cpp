class Solution {
public:
    bool isSink(string city, unordered_map<string, int> outdeg) {
        return outdeg.find(city) == outdeg.end();
    }
    
    string destCity(vector<vector<string>>& paths) {
        
        unordered_map<string, int> outdeg;
        
        int nPaths = paths.size();
        for(int i = 0; i < nPaths; i++) {
            outdeg[paths[i][0]]++;
        }
        
        string dest;
        
        for(int i = 0; i < nPaths; i++) {
            
            if(isSink(paths[i][0], outdeg)) {
                dest = paths[i][0];
                break;
            }
            
            if(isSink(paths[i][1], outdeg)) {
                dest = paths[i][1];
                break;
            }
        }
        
        return dest;
    }
};