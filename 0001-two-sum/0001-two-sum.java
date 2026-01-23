class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] two = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[i] + arr[k] == target) {
                    two[0] = i;
                    two[1] = k;
                }
            }
        }
        return two;
    }
}