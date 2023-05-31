class Solution {
    public int[] shiftLeft(int[] A, int prefix) {
        
        int[] B = new int[A.length + 1];
        
        B[0] = prefix;
        
        for (int i = 0; i < A.length; i++) {
            B[i + 1] = A[i];
        } 
        return B;
    }
    
    public int[] plusOne(int[] digits) {
        
        int carry = 1;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            int totSum = digits[i] + carry;
            
            carry = totSum / 10;
            digits[i] = totSum % 10;
        }
        
        if (carry == 1)
            return shiftLeft(digits, carry);
        else 
            return digits;
    }
}