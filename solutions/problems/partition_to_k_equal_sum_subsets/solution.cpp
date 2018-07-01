class Solution {
public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
     int N = nums.size(), K = k;
     bool d[1<<N];
     int tot[1<<N];
     
     for(int i=0;i<(1<<N);i++)
     {
         d[i] = 0;
         tot[i] = 0;
     }
    
     d[0] = 1;
     tot[0] = 0;
     
     sort(nums.begin(), nums.end());
        
     int sum=0;
     for(int i=0;i<N;i++)
     sum += nums[i];
     
     if(sum % K > 0)
     return false;
     
     int s = sum/K;
     
     if(nums[N-1] > s)
         return false;
        
     for(int i=0;i<(1<<N);i++)
     {
         if(d[i] == 1)
         {
            for(int j=0;j<N;j++)
         {
            int newset = i | (1<<j);
            
            if(newset != i )//&& !d[newset])
            {
                if(nums[j] <= (s-(tot[i]%s)))
            {
                d[newset] = 1;
                tot[newset] = tot[i] + nums[j];
            }
                else break;
            }
        }
        }
    }
     
     return d[(1<<N) - 1];
}
};