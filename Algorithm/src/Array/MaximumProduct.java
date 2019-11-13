package Array;
/*
628 多想想注意事项，最好在纸上画画
 */
public class MaximumProduct {
    public int maximumProduct1(int[] nums) {
        int maxOne = Integer.MIN_VALUE;
        int maxTwo = Integer.MIN_VALUE;
        int maxThree = Integer.MIN_VALUE;
        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= maxOne) {
                maxThree = maxTwo;
                maxTwo = maxOne;
                maxOne = nums[i];
            } else if (maxOne >= nums[i] && nums[i] >= maxTwo) {
                maxThree = maxTwo;
                maxTwo = nums[i];
            } else if (maxThree <= nums[i] && nums[i] <= maxTwo) {
                maxThree = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= minOne) {
                minTwo = minOne;
                minOne = nums[i];
            } else if (nums[i] <= minTwo && nums[i] >= minOne) {
                minTwo = nums[i];
            }
        }
        return Math.abs(minOne) * Math.abs(minTwo) * maxOne > maxOne * maxTwo * maxThree ?
                Math.abs(minOne) * Math.abs(minTwo) * maxOne : maxOne * maxTwo * maxThree;
    }
/*
-------------------------优化了两处
 */
    public int maximumProduct(int[] nums) {
        int maxOne = Integer.MIN_VALUE;
        int maxTwo = Integer.MIN_VALUE;
        int maxThree = Integer.MIN_VALUE;
        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= maxOne) {
                maxThree = maxTwo;
                maxTwo = maxOne;
                maxOne = nums[i];
            } else if (maxOne >= nums[i] && nums[i] >= maxTwo) {
                maxThree = maxTwo;
                maxTwo = nums[i];
            } else if (maxThree <= nums[i] && nums[i] <= maxTwo) {
                maxThree = nums[i];
            }
            if (nums[i] <= minOne) {
                minTwo = minOne;
                minOne = nums[i];
            } else if (nums[i] <= minTwo && nums[i] >= minOne) {
                minTwo = nums[i];
            }
        }
        return Math.max(minOne*minTwo*maxOne,maxOne*maxTwo*maxThree);
    }
    public static void main(String[] args) {
        int[] nums = {-1000,-1000,-1000};
        System.out.println(new MaximumProduct().maximumProduct(nums));
    }
}
