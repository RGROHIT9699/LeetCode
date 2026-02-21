class Solution {
    public int countPrimeSetBits(int l, int r) {
        int ans = 0;
        for (int x = l; x <= r; ++x){
            if (isSmallPrime(Integer.bitCount(x))){
                ans++;
            }
        }
        return ans;
    }
    public boolean isSmallPrime(int x) {
        return (x==2||x==3||x==5||x==7||x==11||x==13||x==17||x==19);
    }
}