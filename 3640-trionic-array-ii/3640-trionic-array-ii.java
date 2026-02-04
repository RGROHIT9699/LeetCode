class Solution {
    private static final long in = Long.MAX_VALUE / 2;
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long res = -in;
        long st1 = -in;
        long st2 = -in;
        long st3 = -in; 

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                st1 = Math.max(st1 + nums[i], nums[i] + nums[i-1]);
                st3 = Math.max(st2 + nums[i], st3 + nums[i]);
                res = Math.max(res, st3);
                st2 = -in;
            } else {
                if (nums[i] < nums[i-1]) {
                    st2 = Math.max(st2 + nums[i], st1 + nums[i]);
                } else {
                    st2 = -in;
                }
                st1 = -in;
                st3 = -in;
            }
        }
        return res;
    }
}