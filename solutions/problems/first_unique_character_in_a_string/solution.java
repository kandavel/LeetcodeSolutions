class Solution {
    public int firstUniqChar(String s) {
        int F[] = new int[26];
        
        for (int i = 0; i<s.length(); i++) {
            F[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i<s.length(); i++) {
            if(F[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}