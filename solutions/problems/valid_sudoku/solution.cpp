class Solution {
public:
    
    bool f(int x, int y, vector<vector<char>>& board)
    {
        vector<int> freq(10);
        int box=1;
        
        for(int i=x;i<x+3;i++)
        {
            for(int j=y;j<y+3;j++)
            {   
                if(board[i][j] == '.')
                        continue;
        
                freq[board[i][j]-48]++;
                if(freq[board[i][j]-48] > 1)
                {
                    box=0;
                    break;
                }
            }
        }
        
        return box;
    }
    
    bool isValidSudoku(vector<vector<char>>& board) {
        
        int n=board.size();
        bool rc=1;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                vector<int> freq(10);
                for(int i=0;i<=9;i++)
                    freq[i]=0;
                
                bool allrow=1, allcol=1;
                
                for(int r=0;r<n;r++)
                {                    
                    if(board[r][j] == '.')
                        continue;
                    
                    freq[board[r][j]-48]++;
                    
                    if(freq[board[r][j]-48] > 1)
                    {
                        allrow=0;
                        break;
                    }
                }
                
                for(int i=0;i<=9;i++)
                    freq[i]=0;
                
                for(int c=0;c<n;c++)
                {
                    if(board[i][c] == '.')
                        continue;
                    
                    freq[board[i][c]-48]++;
                    
                    if(freq[board[i][c]-48] > 1)
                    {
                        allcol=0;
                        break;
                    }
                }
                
                if(allrow == 0 || allcol == 0)
                {
                    rc=0;
                    break;
                }
            }
        }
        
        if(rc==0)
        return 0;
        
        bool box=1;
       for(int i=0;i<9;i+=3)
       {
           for(int j=0;j<9;j+=3)
               box=box & f(i, j, board);
       }
        
       return box;
    }
};