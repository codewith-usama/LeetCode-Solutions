class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        long INF = (long) Math.pow(10, 20);
        long[] total = new long[1 << n];

        for (int mask = 1; mask < (1 << n); mask++) {
            int m = 0;
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) > 0) {
                    m += cookies[j];
                }
            }
            total[mask] = m;
        }

        return (int) go(0, (1 << n) - 1, k, total, new Long[k + 1][1 << n], INF);
    }

    private long go(int index, int mask, int k, long[] total, Long[][] memo, long INF) {
        int n = memo[0].length;
        if (index == k) {
            return mask == 0 ? 0 : INF;
        }

        if (memo[index][mask] != null) {
            return memo[index][mask];
        }

        long res = INF;
        int sub = mask;

        while (sub > 0) {
            res = Math.min(res, Math.max(total[sub], go(index + 1, mask ^ sub, k, total, memo, INF)));
            sub = (sub - 1) & mask;
        }

        memo[index][mask] = res;
        return res;
    }
}
