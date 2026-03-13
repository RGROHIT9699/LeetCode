class Solution {
    public long minNumberOfSeconds(int m, int[] wor) {
        long lo = 0;
        long hi = Long.MAX_VALUE;
        while(lo<=hi){
            long mid = lo+(hi-lo)/2;
            if(ischeck(mid,m,wor)){
                hi = mid - 1;

            } else {
                lo = mid+1;
            }
        }
        return lo;
    }
    public boolean ischeck(long m,int k,int []wor){
        long sum = 0;
        for(int i=0;i<wor.length;i++){
            long temp = (long)(Math.sqrt(1+8.0*m/wor[i])-1)/2;
            sum+=temp;
            if(sum>=k){
                return true;
            }
        }
        return sum>=k;
    }
}