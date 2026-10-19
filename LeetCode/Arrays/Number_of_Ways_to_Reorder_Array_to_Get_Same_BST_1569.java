import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007;
    long[] fact, invFact;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        fact = new long[n+1];
        invFact = new long[n+1];
        buildFactorials(n);

        return (int)((dfs(nums) - 1 + MOD) % MOD); // subtract 1 to exclude original order
    }

    private long dfs(int[] nums) {
        if (nums.length <= 2) return 1;

        int root = nums[0];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < root) left.add(nums[i]);
            else right.add(nums[i]);
        }

        long leftWays = dfs(left.stream().mapToInt(i->i).toArray());
        long rightWays = dfs(right.stream().mapToInt(i->i).toArray());

        int m = left.size(), k = right.size();
        long comb = nCr(m+k, m);

        return (((comb * leftWays) % MOD) * rightWays) % MOD;
    }

    private void buildFactorials(int n) {
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = (fact[i-1] * i) % MOD;
        invFact[n] = modPow(fact[n], MOD-2);
        for (int i = n-1; i >= 0; i--) invFact[i] = (invFact[i+1] * (i+1)) % MOD;
    }

    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n-r]) % MOD;
    }

    private long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}
