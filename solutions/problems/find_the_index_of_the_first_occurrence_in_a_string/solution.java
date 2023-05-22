class Solution {
    public int strStr(String haystack, String needle) {
        
        int l = 0, r = 0, curr = 0;
        int []repeatingCharsTill = new int[needle.length()];

        repeatingCharsTill[0] = 0;

        while (curr < needle.length() && r < haystack.length())
        {
            if(curr > 0 && needle.charAt(curr) == needle.charAt(curr-1))
            repeatingCharsTill[curr] = repeatingCharsTill[curr - 1] + 1;
            else
            repeatingCharsTill[curr] = 0;

            if (needle.charAt(curr) == haystack.charAt(r))
            {
                curr++;
                r++;
            } 
            else {
                //loss case
                // since needle[curr] != haystack[r] & needle[curr] equals all the repeatingCharsAt[curr] before it, all those chars are also != haystack[r]
    //so, we skip the comparisons of those chars

                if (repeatingCharsTill[curr] > 0)
                    curr -= repeatingCharsTill[curr];
                else
                {
                    /*
                    L.  R
                    |.  |
                    abccyabccx

                        curr
                        |
                    abccx

                    */
                    l = l + 1;
                    r = l;
                    curr = 0;
                }
            }
        }

        if (curr == needle.length())
        return l;
        else 
        return -1; 
    }
}