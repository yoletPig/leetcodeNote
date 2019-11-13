package Dynamic;

/**
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 */
public class nthUglyNumber {
    public int nthUglyNumber(int n) {
        //建立一个数组用于按顺序存放丑数
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            //按顺序排，每次选一个最小数
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            //用来防止重复加入同一个数
            //原理：从小开始只是乘2,3,5三个数
            //所以肯定都是丑数，只要做到防止重复和按顺序排就好
            if (min == dp[i2] * 2) {
                i2++;
            }
            if (min == dp[i3] * 3) {
                i3++;
            }
            if (min == dp[i5] * 5) {
                i5++;
            }
            dp[i] = min;
        }

        return dp[n - 1];
    }


    public static void main(String[] args) {
        nthUglyNumber n = new nthUglyNumber();
        int i = 1690;
        int i1 = n.nthUglyNumber(i);
        System.out.println(i1);
    }
}
