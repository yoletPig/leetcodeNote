package Array;

import java.util.HashSet;

/**
 * 41.缺失的第一个正整数
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * 我能通过但不及格！
 * 我能通过但不及格！
 * 我能通过但不及格！
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        //找到数组中最小值；
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) {
              if (nums [i] < min){
                  min = nums [i];
              }
              set.add(nums [i]);
            }
        }
        //只要min不等于1就返回1
        if (min==1){
            int i = 2;
            while (i<=set.size()){
                if (!set.contains(i)){
                    return i;
                }
                i++;
            }
            return i;
        }
        return 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] nums = {Integer.MAX_VALUE};
        int positive = firstMissingPositive.firstMissingPositive(nums);
        System.out.println(positive);
    }
}
