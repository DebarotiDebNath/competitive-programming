class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        return IntStream.rangeClosed(1, n)
                .filter(i -> n % i == 0)
                .map(i -> nums[i - 1] * nums[i - 1]).sum();
    }
}