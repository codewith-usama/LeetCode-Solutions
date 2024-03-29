class Solution {
public:
    int minimumDeleteSum(string s1, string s2) {
        int m = s1.size(), n = s2.size();
        
        vector<vector<int>> dp(m+1, vector(n+1, 0));
        
        //s1[i:] with s2[n:](empty string)
        for(int i = m-1; i >= 0; i--){
            dp[i][n] = dp[i+1][n] + (int)s1[i];
        }
        
        //s1[m:](empty string) with s2[j:]
        for(int j = n-1; j >= 0; j--){
            dp[m][j] = dp[m][j+1] + (int)s2[j];
        }
        
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                // cout << s1.substr(i) << " " << s2.substr(j) << " ";
                if(s1[i] == s2[j]){
                    dp[i][j] = dp[i+1][j+1];
                    // cout << "not delete" << endl;
                }else{
                    //whether delete from s1 or s2
                    dp[i][j] = min(dp[i+1][j] + (int)s1[i], 
                                  dp[i][j+1] + (int)s2[j]);
                    // if(dp[i+1][j] + (int)s1[i] < dp[i][j+1] + (int)s2[j]){
                    //     cout << "delete " << s1[i] << endl;
                    // }else{
                    //     cout << "delete " << s2[j] << endl;
                    // }
                }
            }
        }
        
        return dp[0][0];
    }
};