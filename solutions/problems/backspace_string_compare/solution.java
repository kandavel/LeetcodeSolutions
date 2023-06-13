class Solution {

    public String processStr(String s) {
        String t = new String();

        if (s.isEmpty())
        return t;

        int i = s.length() - 1;
        int ct = 0;

        while(i >= 0){
            char currChar = s.charAt(i);

            if (currChar == '#') {
                ct++;
            } else {
                if (ct > 0)
                ct--;
                else 
                {
                    
                    t += currChar;
                }
            }
            // System.out.println("i="+i+",ct="+ct+",t="+t);
            i--;
        }
System.out.println(t);
        return t;
    }

    public boolean backspaceCompare(String s, String t) {
        return processStr(s).equals(processStr(t));
    }
}