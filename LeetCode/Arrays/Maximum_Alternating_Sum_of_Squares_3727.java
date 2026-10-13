class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] sq = new long[n];
        for (int i = 0; i < n; i++) sq[i] = (long) nums[i] * nums[i];

        // Find median split using quickselect
        int m = n / 2;
        nthElement(sq, m); // partition so first m are smallest

        long ans = 0;
        for (int i = 0; i < m; i++) ans -= sq[i];
        for (int i = m; i < n; i++) ans += sq[i];
        return ans;
    }

    // Quickselect partition
    private void nthElement(long[] arr, int n) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            long pivot = arr[(left + right) >>> 1];
            int i = left, j = right;
            while (i <= j) {
                while (arr[i] < pivot) i++;
                while (arr[j] > pivot) j--;
                if (i <= j) {
                    long tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
                    i++; j--;
                }
            }
            if (n <= j) right = j;
            else if (n >= i) left = i;
            else return;
        }
    }
}