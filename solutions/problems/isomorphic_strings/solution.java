class Solution {

    public boolean isEqual(int []A, int []B) {
        for(int i = 0; i < A.length; i++)
        {
            if (A[i] != B[i])
            return false;
        }
        return true;
    }

    public int[] normalisedOrder(String s) {
        int []normalisedOrderOfChars = new int[s.length()];

        int []uniqueOrderOfChar = new int[128];
        int noOfUniqueCharsSoFar = 0;

        for (int i = 0; i < s.length(); i++) {
            int intAsciiChar = 128 - s.charAt(i);
            if (uniqueOrderOfChar[intAsciiChar] == 0)
            {
                noOfUniqueCharsSoFar++;
                uniqueOrderOfChar[intAsciiChar] = noOfUniqueCharsSoFar;
            }
            normalisedOrderOfChars[i] = uniqueOrderOfChar[intAsciiChar];
        }
        return normalisedOrderOfChars;
    }

    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length())
        return false;

        return isEqual(normalisedOrder(s), normalisedOrder(t));
    }
}