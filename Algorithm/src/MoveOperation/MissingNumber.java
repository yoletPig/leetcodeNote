package MoveOperation;
/*
*268 缺失数字
*给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
*
*示例 1:
*
*输入: [3,0,1]
*输出: 2
*示例 2:
*
*输入: [9,6,4,2,3,5,7,0,1]
*输出: 8
*
 */
public class MissingNumber {
    //异或方法
    public int missingNumber1(int[] nums) {
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            res ^= i^nums[i-1];
        }
        return res;
    }

    //数学方法
    //nums的长度为最大的数字；
    public int missingNumber2(int[] nums){
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        int sum2 = (nums.length+1)*nums.length/2;
        return sum2-sum;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {1, 0, 3};
        System.out.println(missingNumber.missingNumber2(nums));
    }
}
