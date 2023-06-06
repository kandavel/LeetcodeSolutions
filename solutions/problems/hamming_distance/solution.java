class Solution {
    public int noOfSetBits(int x) {
        int ct = 0;
        while(x > 0) {
            ct += (x & 1);
            
            x = x >> 1;
        }
        return ct;
    }
    
    public int hammingDistance(int x, int y) {
        return noOfSetBits(x^y);
    }
}