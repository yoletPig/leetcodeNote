package Dynamic;
import	java.util.Arrays;

/**
 * 硬币组合（第一种方法用的是动归）
 *
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        //建立动态规划数组用于存放当前cur值用的最少硬币数。
        int[] dp = new int[amount + 1];
        int min;
        Arrays.sort(coins);
        for (int i = 1; i < dp.length; i++) {
            int j = 0;
            min = Integer.MAX_VALUE;
            //在dp数组的第 i-couns[j] 中找到最小值，注意不等于0 ；
            while (j < coins.length && i - coins[j] > 0) {
                if (dp[i-coins [j]]!=0){
                    if (min > dp[i-coins [j]]){
                        min = dp[i-coins [j]];
                    }
                }
                j++;
            }

            if (j<coins.length&&i == coins[j]){
                dp [i] = 1;
                continue;
            }
           if (min != Integer.MAX_VALUE){
               dp [i] = min + 1;
           }
        }
       if (dp[dp.length - 1]==0){
           return -1;
       }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {83,474,404,3};
        int i = cc.coinChange(coins, 264);
        System.out.println(i);
    }
}
