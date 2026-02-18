class Solution {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        int i = s.length()-1;
        int j = i-1;
        while(j>=0) {
            if(s.charAt(i) == s.charAt(j)) {
                return false; 
            }
            i--;
            j--;

        }
        return true;
        
    }
}