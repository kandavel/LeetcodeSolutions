class Solution {
    public boolean isDig(char c) {
        return (c >= '0' && c <= '9');
    }
    
    public boolean isSign(char c) {
        return (c == '+' || c == '-');
    }
    
    public boolean isNum(char c) {
        return isSign(c) | isDig(c);
    }
    
    public boolean canHandleSingleDig(int dig, int num) {
        
        if (num >= 0)
            return (Integer.MAX_VALUE - num  >= dig);
        else
            // Negative number range extends till MAX_VAL + 1 
            // -4, -3, -2, -1, 0, 1, 2, 3 
            // to accomodate 0 - a non-negative integer
            
            // MIN - negNum >= (-)dig
            // -(MAX+1) - (-)abs >= (-)dig
            //
            // MAX + 1 - abs >= dig
            // Right side of this inequality will exceed limits if absVal == 0
            // MAX - abs >= dig - 1
            
            return Integer.MIN_VALUE - num <= dig;
    }
    
    public boolean canMulByTen(int num) {
        // the last ones dig anyway will be truncated after div, 
        // so, MAX int val comparison is sufficient to determine 
        // if the absVal is smaller by atleast an order of ten
        
         // System.out.println(absVal);
        if (num >= 0)
            return Integer.MAX_VALUE/10  >= num;
        else 
            return Integer.MIN_VALUE/10 <= num;
    }
    
    public Integer clampedVal(int num) {
        return (num >= 0 ? Integer.MAX_VALUE: Integer.MIN_VALUE);
    }
    
    public void makeSigned(char sign, int absVal) {
        absVal *= (sign == '+' ? 1: -1);
    }
    
    public int myAtoi(String s) {
        
        int num = 0;
        int i = 0;
        
        char sign = '+';
        int multiplier = 1;
        char curr = '0';
        while(i < s.length()) {
            
            curr = s.charAt(i);
            
            if (curr == ' ')
                i++;
            else if (isSign(curr)) {
                sign = curr;
                multiplier = (sign == '+'? 1: -1);
                i++;
                break;
            } else if (isNum(curr)) {
                break;
            } else {
                // curr char is not a whitespace nor a sign nor a digit, so, invalid string
                    return 0;
            }
        }
        
        // reached end of string without seeing any sign or digit
        if (i == s.length())
            return 0;
        
        //parse the string chars and convert into int val
        while(i < s.length()) {
            
            curr = s.charAt(i++);
            if (!isDig(curr))
                break;
            
            // shift the running weighted sum to the left
            // in decimal system, that's an order of 10
            
            System.out.println(num);
            
            // Case 1: number bigger than limits by atleast an order of 10
            
            // if we had a borderline case that exceeds the limits by atleast an order of 10, 
            // then this int var wuld go neg at an exact iteration 
            // due to rolling of the values, clamping needed here too
            
            if (canMulByTen(num))
                num *= 10; 
            else
                return clampedVal(num);
            
            // Case 2: number bigger by less than an order of 10, single digit difference
            
            // before adding the curr digit, see if we're ready to even do this addition 
            // check the integer ceil and flr vals for pos and neg integers respectively
            
            int dig = multiplier*(curr - '0');
                
            if (canHandleSingleDig(dig, num))
                num += dig;
            else
                return clampedVal(num);
        }
        return num;
    }
}