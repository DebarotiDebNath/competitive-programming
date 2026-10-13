class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sumOfSqrs = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) sumOfSqrs += (int) Math.pow(nums[i - 1], 2);
        }
        return sumOfSqrs;
    }
}