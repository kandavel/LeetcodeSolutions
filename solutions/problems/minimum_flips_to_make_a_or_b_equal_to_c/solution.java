class Solution {
    public int minFlips(int a, int b, int c) {

        int flips = 0;

        // a b c
        // 0 0 1
        // 0 1 0
        // 1 1 0
        // 1 0 0

        int atleastOneBitInABDifferentFromC = (a|b)^c;

        // a b c
        // 1 1 0
        int BothAAndBBitsSet = (a & b);
        int morethanOneBitInABDifferentFromC = 
        BothAAndBBitsSet & atleastOneBitInABDifferentFromC;

        return Integer.bitCount(atleastOneBitInABDifferentFromC) + 
        Integer.bitCount(morethanOneBitInABDifferentFromC);
    }
}