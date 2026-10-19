class Solution {
    public int sumCounts(int[] nums) {
        final long MOD = 1_000_000_007;
        int n = nums.length;
        long ans = 0, cur = 0;

        // Fenwick tree arrays
        long[] countBIT = new long[n + 2];
        long[] sumBIT = new long[n + 2];
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int r = 0; r < n; r++) {
            int val = nums[r];
            int p = lastSeen.getOrDefault(val, -1) + 1; // previous index + 1

            // Query BIT for range [p, r]
            long c = 0, s = 0;
            for (int i = n - p; i > 0; i -= i & -i) {
                c += countBIT[i];
                s += sumBIT[i];
            }

            // Contribution formula
            long gain = (long)(r - p + 1) * (r - p + 1) - 2 * (s - (long)p * c);
            cur = (cur + gain) % MOD;
            ans = (ans + cur) % MOD;

            // Update BIT with p
            for (int i = n - p; i <= n; i += i & -i) {
                countBIT[i]++;
                sumBIT[i] += p;
            }

            lastSeen.put(val, r);
        }

        return (int) ans;
    }
}