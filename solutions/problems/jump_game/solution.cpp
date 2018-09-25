
struct cell
{
    int i, jumps;
};

int bfs(vector<int> &A)
{
    int n = A.size();
    vector<bool> visited(n, 0);
    
    queue<cell> q;
    
    cell temp;
    temp.i = 0;
    temp.jumps = 0;
    
    q.push(temp);
    
    visited[0] = 1;
    
    while(!q.empty())
    {
        cell curr = q.front();
        q.pop();
        
        visited[curr.i] = 1;
        
        if(curr.i == n-1)
        return 1;//curr.jumps;
        
        if(A[curr.i] == 0)
        continue;
        
        A[curr.i] = min(A[curr.i], n-1-curr.i);
        for(int x=A[curr.i];x>=1;x--)
        {
            if(!visited[curr.i+x])
            {
                cell frw;
                frw.i = curr.i+x;
                frw.jumps = curr.jumps+1;
                
                visited[curr.i+x] = 1;
                
                q.push(frw);
            }
        }
    }
    
    return 0;
}


class Solution {
public:
    bool canJump(vector<int>& nums) {
        return bfs(nums);
    }
};