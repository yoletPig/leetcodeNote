package Dynamic;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int [nums.length];
        int maxValue ;
        int maxLength = 0 ;
        for (int i = 0; i < nums.length; i++) {
            maxValue = 0;
            for (int j = 0; j < i ; j++) {
                if (nums[j] < nums[i] ){
                    maxValue = Math.max(maxValue,dp[j]);
                }
            }
            dp[i] = maxValue+1;
            if (dp [i]>maxLength){
                maxLength = dp [i];
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLIS l = new LengthOfLIS();
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(l.lengthOfLIS(nums));
    }
}
