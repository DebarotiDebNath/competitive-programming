class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        // Step 1: square each element
        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }

        // Step 2: sort squared values
        Arrays.sort(nums);

        long ans = 0;
        int m = n / 2;

        // Step 3: subtract smaller half
        for (int i = 0; i < m; i++) {
            ans -= nums[i];
        }

        // Step 4: add larger half
        for (int i = m; i < n; i++) {
            ans += nums[i];
        }

        return ans;
    }
}