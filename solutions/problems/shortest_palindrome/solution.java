class Solution {
    public String shortestPalindrome(String s) {
        
        int l = 0, r = s.length() - 1;
        int m = s.length()/2;

        int even = 1 - s.length()%2;

        while(m >= 0) {

            l = m - 1;
            r = m + 1 - even;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                l--; r++;
            }
            if (l == -1)
            break;
            else 
            {
                m = m - even;
                even = 1 - even;
            }
        }
        String t = "";
        int e = s.length() - 1;

        while(e > r)
        t += s.charAt(e--);

        if (r > 0 && r < s.length())
        t += s.charAt(r);

        t += s;

        return t;
    }
}