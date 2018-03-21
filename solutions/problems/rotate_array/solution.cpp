class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n=nums.size();
        k=k%n;
        
        /*
        for(int i=0;i<k;i++)
        {
            int p=nums[0];
            for(int j=n-1;j>=0;j--)
            {
                nums[(j+1)%n] = nums[j];
            }
            
            nums[1]=p;
        }
        */
        for(int i=0;i<(n-k)/2;i++)
        {
            int temp = nums[n-k-1-i];
            nums[n-k-1-i] = nums[i];
            nums[i]     = temp;
        }
         /*for(int i=0;i<n;i++)
            cout<<nums[i]<<" ";
        cout<<endl;
        */
        for(int i=0;i< k/2;i++)
        {
            int temp = nums[n-1-i];
            nums[n-1-i] = nums[i+n-k];
            nums[i+n-k] = temp;
        }
        /*
        for(int i=0;i<n;i++)
            cout<<nums[i]<<" ";
        */
        for(int i=0;i< n/2;i++)
        {       
            int temp = nums[n-1-i];
            nums[n-1-i] = nums[i];
            nums[i]     = temp;
        }
    }
};