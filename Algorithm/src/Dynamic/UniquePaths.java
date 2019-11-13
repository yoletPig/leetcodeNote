package Dynamic;
/*
62 不同路径
数学归纳法，找最小问题的解。
arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
动态规划都会有这么一个方程，找出来就完事了
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            arr[1][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            arr[i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[n][m];
    }
}
