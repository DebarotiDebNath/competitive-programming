class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] bitCount = new int[31]; // up to 2^30

        // Count how many times each bit has appeared
        for (int num : nums) {
            for (int b = 0; b < 31; b++) {
                if (((num >> b) & 1) == 1) {
                    bitCount[b]++;
                }
            }
        }

        // Build k numbers by distributing bits
        long[] chosen = new long[k];
        for (int b = 30; b >= 0; b--) {
            int count = bitCount[b];
            for (int i = 0; i < count && i < k; i++) {
                chosen[i] |= (1L << b);
            }
        }

        // Compute sum of squares
        long result = 0;
        for (int i = 0; i < k; i++) {
            result = (result + (chosen[i] * chosen[i]) % MOD) % MOD;
        }
        return (int) result;
    }
}