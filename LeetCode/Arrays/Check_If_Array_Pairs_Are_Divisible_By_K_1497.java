class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];

        // Step 1: count remainders
        for (int num : arr) {
            int remainder = ((num % k) + k) % k; // handle negatives
            freq[remainder]++;
        }

        // Step 2: check pairing conditions
        if (freq[0] % 2 != 0) return false; // multiples of k must pair

        for (int r = 1; r <= k/2; r++) {
            if (r == k - r) { // when k is even
                if (freq[r] % 2 != 0) return false;
            } else {
                if (freq[r] != freq[k - r]) return false;
            }
        }
        return true;
    }
}