class Solution {
    public long minimumCost(String sou, String tar, char[] ori, char[] cha, int[] cost) {
        int[][] arr = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            arr[ori[i] - 'a'][cha[i] - 'a'] = Math.min(arr[ori[i] - 'a'][cha[i] - 'a'], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (arr[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 26; j++) {
                        if (arr[k][j] < Integer.MAX_VALUE) {
                            arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                        }
                    }
                }
            }
        }
        long ans = 0L;
        for (int i = 0; i < sou.length(); i++) {
            int c1 = sou.charAt(i) - 'a';
            int c2 = tar.charAt(i) - 'a';
            if (arr[c1][c2] == Integer.MAX_VALUE) {
                return -1L;
            } else {
                ans += (long) arr[c1][c2];
            }
        }
        return ans;
    }
}