class Solution {
public:
    int bitwiseComplement(int N) {
        
        if(N == 0)
            return 1;
        
        vector<int> v;
        
        int mask = 1;
        
        while(mask < N) {
            
            
            //Visualise
            //initially, mask = 
            //__________1
            //mask<<1 = 
            //_________1_
            //mask<<1 + 1 =
            //_________11
            
            //So, mask<<1 + 1 is shifting that earlier mask to the right and fillings the least significant bit just emptied with 1
            //Since we started with mask = 1, this is giving us an all 1s binary with no of the 1s equal to the total iterations + 1;
            
            mask = (mask<<1) + 1;
        }
        
        //complement is the bitwise diff of our input number with the all 1s mask :)
        return mask^N;
    }
};