class Solution {
    
    public String getLCPUtil(String a, String b) {
        int l = 0, r = Math.min(a.length(), b.length()); //O(1)
        
        String lcp = "";
        
        if (a.equals(b)) //O(1)
            return a; //O(1)
        
        while (l < r){
            if (a.charAt(l) != b.charAt(l))
                break;
            else 
                lcp += a.charAt(l); //O(1)
            
            l++;
        }
        return lcp;
    }
    
    public String getLCP(String[] strs, int l, int r) {
        
        if (l >= r)
            return strs[r];
        
        if (r - l == 1)
            return getLCPUtil(strs[l], strs[r]);
        
        int m = l + (r-l) /2;
        
        return getLCPUtil(getLCP(strs, l, m), getLCP(strs, m + 1, r));
    }
    
    public String longestCommonPrefix(String[] strs) {
        
        return getLCP(strs, 0, strs.length - 1);
        
    }
}