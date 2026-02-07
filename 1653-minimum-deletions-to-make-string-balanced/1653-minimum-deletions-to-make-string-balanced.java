class Solution {
    public int minimumDeletions(String s) {
        int ans = 0;
        int cou = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'b'){
                cou++;
            }
            else if (cou>0){
                ans++;
                cou--;
            }
        }
        return ans;
    }
}