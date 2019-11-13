package Array;

import java.util.Arrays;

/**
 * 561 数组拆分
 */
public class arrayPairSum {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i%2==0){
                sum+=nums[i];
            }
        }
        return sum;
    }
}
