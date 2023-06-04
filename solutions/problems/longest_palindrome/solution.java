class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        int F[] = new int[128];

        for (int i = 0; i < n; i++)
        {
            F[s.charAt(i)]++;
        }
        
        int maxOdd = 0;

        int l = 0;
        int evenF = 0;
        int oddF = 0;
        int ctOddChars = 0;
        for (int i = 0; i < n; i++)
        {
            int f = F[s.charAt(i)];
            if (f % 2 == 0)
                evenF += f;
            else
                {
                    evenF += (f - 1);
                    ctOddChars++;
                }

            F[s.charAt(i)] = 0;
        }
        l = evenF + (ctOddChars > 0? 1: 0);
        return l;
    }
}