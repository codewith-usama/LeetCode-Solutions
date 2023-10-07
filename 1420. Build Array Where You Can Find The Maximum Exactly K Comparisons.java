class Solution(object):
    def numOfArrays(self, n, m, k):
        """
        :type n: int
        :type m: int
        :type k: intå
        :rtype: int
        """
        mod = 10**9+7
        dp = [[[0 for _ in range(k+1)] for _ in range(m)] for _ in range(n)]
        for j in range(m):
            dp[0][j][1] = 1
 
        for i in range(1,n):
            for j in range(m):
                for k in range(1,k+1):
                    dp[i][j][k] = dp[i-1][j][k] * (j+1)
                    for jj in range(j):
                        dp[i][j][k] += dp[i-1][jj][k-1]
                    dp[i][j][k] %= mod
 
        return sum(dp[n-1][idx][k] for idx in range(m)) % mod
 