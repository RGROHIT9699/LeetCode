class Solution {
    int find(char a,char b,String s){
        int n= s.length();
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnta =0,cntb = 0;
        int ans = 0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr!=a&&curr!=b){
                cnta = 0;
                cntb = 0;
                map = new HashMap<>();
                map.put(0,i);
            }
            else if(curr==a) {
                cnta++;
            } 
            else cntb++;
            int diff = cnta-cntb;
            if(map.containsKey(diff)){
                int left = map.get(diff);
                ans = Math.max(ans,i-left);
            }
            else{
                map.put(diff,i);
            }
        }
        return ans;
    }
    
    int threeCase (String s){
        int cnta = 0,cntb = 0,cntc = 0;
        HashMap<String,Integer> map = new HashMap<>();
        int ans = 0;
        map.put("0#0",-1);
        int n =s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='a') cnta++;
            if(c=='b') cntb++;
            if(c=='c') cntc++;
            String diff = ""+(cnta-cntb)+"#"+(cnta-cntc);
            if(map.containsKey(diff)){
                ans = Math.max(ans,i-map.get(diff));
            }
            else{
                map.put(diff,i);
                }
            }
        return ans;
    }
    
    public int longestBalanced(String s) {
        // case 1
        int ans=1,curr=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                curr++;
                ans = Math.max(ans,curr);
            }
            else{
               curr=1;
            }
        }
        
        // case 2 
        ans = Math.max(ans,find('a','b',s));
        ans = Math.max(ans,find('b','c',s));
        ans = Math.max(ans,find('c','a',s));
        
        // case 3
        ans = Math.max(ans,threeCase(s));

        return ans;
    }
}