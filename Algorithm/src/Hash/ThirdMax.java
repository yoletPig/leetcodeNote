package Hash;

import java.util.HashSet;
/*
给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

示例 1:

输入: [3, 2, 1]

输出: 1

解释: 第三大的数是 1.
示例 2:

输入: [1, 2]

输出: 2

解释: 第三大的数不存在, 所以返回最大的数 2 .
示例 3:

输入: [2, 2, 3, 1]

输出: 1

解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
存在两个值为2的数，它们都排第二。

 */
public class ThirdMax {
    public static int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int One = Integer.MIN_VALUE;
        int Two = Integer.MIN_VALUE;
        int Three = Integer.MIN_VALUE;
        if (nums.length==2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        if (nums.length==1)
        {
            return nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                continue;
            }
            else {
                set.add(nums[i]);
                if (nums[i]>One){
                    Three = Two;
                    Two = One;
                    One = nums[i];
                }
                if (One>nums[i]&&nums[i]>Two){
                    Three = Two;
                    Two = nums[i];
                }
                if (Two>nums[i]&&nums[i]>=Three){
                    Three = nums[i];
                }
            }
        }
        if (set.size()<3)
        {
            return One;
        }
        return Three;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        System.out.println(thirdMax(nums));
    }
}
