package Hash;
import	java.util.HashMap;
import java.util.Map;

public class findMaxLength {
    /**
     * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [0,1]
     * 输出: 2
     * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
     * 示例 2:
     *
     * 输入: [0,1,0]
     * 输出: 2
     * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
     * @param nums
     * @return
     *
     * 思路：对于这种最长 连续的 可以考虑用前缀和去求。
     */
    public int findMaxLength(int[] nums) {
        int res = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0 && i > res) {
                res = i + 1;
            }
            if (map.containsKey(sum)) {
                res = Math.max(i - map.get(sum), res);
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,0,1};
        findMaxLength fml = new findMaxLength();
        fml.findMaxLength(nums);
    }
}
