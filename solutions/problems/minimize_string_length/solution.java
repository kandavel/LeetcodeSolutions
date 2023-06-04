class Solution {
    public int minimizedStringLength(String s) {
        int F[] = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            F[s.charAt(i)-'a']++;
        }
        
        int ct = 0;
        for(int i = 0; i < 26; i++) 
            ct += (F[i] > 0? 1: 0);
        return ct;
    }
}