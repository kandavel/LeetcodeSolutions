class Solution {
    
    public String replaceAllUpperLetterNonLetter(String s) {
        // String regex = "\\W";
        String regex = "[^a-zA-Z0-9]";
        
        String onlyLowerLetters = s.replaceAll(regex, "").toLowerCase();
        
        regex = "_+";
        onlyLowerLetters = onlyLowerLetters.replaceAll(regex, "").toLowerCase();
        
        return onlyLowerLetters;
    }
    
    public boolean isPalindrome(String s) {
        
        s = replaceAllUpperLetterNonLetter(s);
        System.out.println(s);
        
        int l = 0, r = s.length() - 1;
        
        while(l < r) {
            if(s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}