package Dynamic;

public class minFallingPathSum {
    public int minFallingPathSum1(int[][] A) {
        int[][] dp = new int [A.length] [A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                dp[i][j] = A[i][j]+dp[i-1][j];
                for (int k = j-1; k <= j+1; k++) {
                    if (k>=0&&k<A[i].length){
                        dp[i][j] = Math.min(dp[i][j],A[i][j]+dp[i-1][k]);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i : dp[A.length - 1]) {
            if (ans>i){
                ans = i;
            }
        }
        return ans;
    }


    public int minFallingPathSum(int[][] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j==0){
                    A[i][j] += Math.min(A[i-1][0],A[i-1][1]);
                }else if (j==A.length - 1){
                    A[i][j] += Math.min(A[i-1][A.length -1],A[i-1][A.length - 2]);
                }
                else {
                    A[i][j] += Math.min(Math.min(A[i-1][j-1],A[i-1][j]),A[i-1][j+1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i : A[A.length - 1]) {
            if (ans>i){
                ans = i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        /*minFallingPathSum mf = new minFallingPathSum();
        int[][] A = {{17,82},{1,-44}};
        System.out.println(mf.minFallingPathSum(A));*/

    }
}
