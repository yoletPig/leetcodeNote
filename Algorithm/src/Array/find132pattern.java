package Array;

/**
 * 做题耗时2h，垃圾解法！击败13%
 */

public class find132pattern {
    public boolean find132pattern(int[] nums) {
        int[] result = new int[3];
        if (nums.length < 3) {
            return false;
        }
        result[0] = nums[0];
        int len = 1;
        int a = nums[nums.length - 1];
        int b = nums[nums.length - 2];
        int c = nums[nums.length - 3];
        if (a > c && a < b) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {
            if (len == 1) {
                if (nums[i] < result[0]) {
                    result[0] = nums[i];
                } else if (nums[i] > result[0]) {
                    result[1] = nums[i];
                    len++;
                }
            } else if (len == 2) {
                if (i < nums.length - 3) {
                    int j = i;
                    while (j<nums.length){
                        if (nums[j] > result[0] && nums[j] < result[1]) {
                            return true;
                    }
                        j++;
                    }
                    if (nums[i] < result[0]) {
                        result[0] = nums[i];
                        result[1] = 0;
                        len = 1;
                    } else if (nums[i] > result[1]) {
                        result[1] = nums[i];
                    } else if (nums[i] > result[0] && nums[i] < result[1]) {
                        return true;
                    }
                } else {
                    if (nums[i] > result[0] && nums[i] < result[1]) {
                        return true;
                    } else if (nums[i] > result[1]) {
                        result[1] = nums[i];
                    }
                }
            }
        }
         return false;
    }

    //大佬做法！
        public boolean find132pattern1(int[] nums) {
            int len = nums.length;
            int top = -1;
            int[] stack = new int[len];
            int second = Integer.MIN_VALUE;
            for (int i = len - 1; i >= 0; i--) {
                if (nums[i] < second) {
                    return true;
                }
                while (top != -1 && stack[top] < nums[i]) {
                    second = stack[top--];
                }
                stack[++top] = nums[i];
            }
            return false;
        }


    public static void main (String[]args){
        find132pattern f123 = new find132pattern();
        int[] nums = {4,8,7,6,2,3,5};
        System.out.println(f123.find132pattern1(nums));
    }
}