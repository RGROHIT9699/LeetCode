class Solution {
    public int minFlips(String s) {
        int s0 = 0, s1 = 0, n = s.length();
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < n * 2; i++) {
            char ch = s.charAt(i % n);
            char tmp = flag ? '1' : '0';
            if (ch != tmp) {
                ++s0;
            } else {
                ++s1;
            }
            flag = !flag;
            if (i >= n) {
                int out = i - n;
                char outch = s.charAt(out);
                boolean outflag = ((out % 2) != 0);
                char outtmp = outflag ? '1' : '0';
                if (outch != outtmp) {
                    --s0;
                } else {
                    --s1;
                }
            }
            if (i >= n - 1) {
                min = Math.min(min, Math.min(s0, s1));
            }
        }
        return min;
    }
}