package Dynamic;

/**
 * 279
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 动态规划：其实想状态转移方程不容易，但步骤其实就几个；
 * 1. 分析题目，看到“最少”关键字，然后案例那里 可以看出
 * 一个数的最少倍数的个数跟前面的数有关；
 * 2. 分析寻找状态转移方程（数学归纳法）
 * 3. 实现状态转移方程（一般从数组开头开始）
 */
public class NumSquares {
    public int numSquares(int n) {
        int min;
        int temp;
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
                min=Integer.MAX_VALUE;
            for (int j = (int)Math.sqrt(i); j >= 1 ; j--) {
                temp = arr[i-j*j]+1;
                if (min > temp){
                    min = temp;
                }
            }
            arr[i] = min;
        }
        return arr[n];
    }

    public static void main(String[] args) {
        NumSquares n = new NumSquares();
        System.out.println(n.numSquares(225));
    }
}
