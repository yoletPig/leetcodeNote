package Dynamic;

public class longestSum {
    /**
     * 求一个序列的最大子段和即最大连续子序列之和。例如序列[4, -3, 5, -2, -1, 2, 6, -2]的最大子段和为11=[4+(-3)+5+(-2)+(-1)+(2)+(6)]。
     * @param nums
     * @return
     */
    public int longestSum(int[]nums){
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum+nums [i])>nums[i]?(sum+nums [i]):nums [i];
            if (ans<sum){
                ans = sum;
            }
        }
        return ans;
    }
}
