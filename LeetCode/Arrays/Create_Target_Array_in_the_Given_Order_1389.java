class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        int n = 0;

        for (int i = 0; i < nums.length; i++) {
            int pos = index[i];
            int val = nums[i];

            for (int j = n; j > pos; j--) target[j] = target[j - 1];
            target[pos] = val;
            n++;
        }
        return target;
    }
}