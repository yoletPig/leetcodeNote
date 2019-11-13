package Array;
import java.util.Arrays;
public class findErrorNums {
    public int[] findErrorNums(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int[] res = new int[nums.length + 1];
        for (int num : nums) {
            res[num] += 1;
        }
        int[] arr = new int[2];
        for (int i = 1; i < res.length; i++) {
            if (res[i] == 2) {
                arr[0] = i;
            }
            if (res[i] == 0) {
                arr[1] = i;
            }
        }
        return arr;
    }
}