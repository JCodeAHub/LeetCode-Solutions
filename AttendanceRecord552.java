public class AttendanceRecord {
    public int checkRecord(int n) {
        int MOD = 1000000007;

        // dp[i][j][k] means the number of valid sequences of length i,
        // with j 'A's and ending with k consecutive 'L's.
        int[][][] dp = new int[n + 1][2][3];
        
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // For ending with 'P', reset the L count to 0
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }
            // For ending with 'A', reset the L count to 0, and increment A count
            for (int k = 0; k < 3; k++) {
                for (int j = 1; j < 2; j++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j - 1][k]) % MOD;
                }
            }
            // For ending with 'L', increment the L count
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }

        int result = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                result = (result + dp[n][j][k]) % MOD;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AttendanceRecord ar = new AttendanceRecord();
        System.out.println(ar.checkRecord(2)); // Output: 8
    }
}
