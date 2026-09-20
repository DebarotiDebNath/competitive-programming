class Solution {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        int left = 0;
        int result = 0;
        for (int count : freq.values()) {
            int right = nums.length - left - count;
            result += left * count * right;
            left += count;
        }
        return result;
    }
}