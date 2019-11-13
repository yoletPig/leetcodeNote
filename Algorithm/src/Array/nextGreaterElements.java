package Array;

import java.util.Arrays;

/**
 * 503. 下一个更大元素 II
 * 暴力用时 500ms 击败5%；
 */
public class nextGreaterElements {
    public int[] nextGreaterElements1(int[] nums) {
        int[] arr = new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            while (j%nums.length != i){
                j%=nums.length;
                if (nums [j] > nums [i]){
                    arr[i] = nums[j];
                    break;
                }
                j++;
            }
            if (j%nums.length == i){
                arr[i] = -1;
            }
        }
        return arr;
    }

    /**
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 18 ms
     * , 在所有 Java 提交中击败了
     * 93.78%
     * 的用户
     * 内存消耗 :
     * 52.2 MB
     * , 在所有 Java 提交中击败了
     * 59.46%
     * 的用户
     *
     */

    public int[] nextGreaterElements(int[] nums){
        if (nums.length==0){
            return nums;
        }
        //标识最后一个元素有没有被赋值；
        boolean flag = false;
        //找出最后一个元素的答案
        int[] arr = new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums [i]>nums [nums.length-1]){
                arr[nums.length - 1] = nums [i];
                flag = true;
                break;
            }
        }
        if (!flag){
            arr[nums.length-1] = -1;
        }
        //从下往上开始循环，
        // 总共有这几种结果，
        // nums [i]<nums[i+1] 如 1,2 那么 arr[i] = nums [i+1] = 2;
        // nums [i] > nums [i+1] 这里又分两种情况：有没有大于或等于arr[i+1]的值，
        // 如果有就需要遍历整个数组去查询，
        // 否则就是  arr[i] = arr[i+1];  5,4,3,2,6
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums [i]<nums[i+1]){
                arr[i] = nums [i+1];
               continue;
            }
            if(nums [i] > nums [i+1]){
                if (nums[i]<arr[i+1]){
                    arr[i] = arr[i+1];
                }
                else {
                    int j = i%nums.length+1;
                    while (j!=i){
                        if (nums[j]>nums[i]){
                            arr [i] = nums [j];
                            break;
                        }
                        j++;
                        j%=nums.length;
                    }
                    if (j==i){
                        arr[i] = -1;
                    }
                }
            }
            else {
                arr [i] = arr [i+1];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        nextGreaterElements nge = new nextGreaterElements();
        int[] nums = {1,2,3,4,3};
        System.out.println(Arrays.toString(nge.nextGreaterElements(nums)));
    }
}
