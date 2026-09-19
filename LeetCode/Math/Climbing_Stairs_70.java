class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int i = 1;
        int j = 2;

        for (int step = 3; step <= n; step++) {
            int k = i + j;
            i = j;
            j = k;
        }
        return j;
    }
}