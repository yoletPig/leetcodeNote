package Array;

import java.util.ArrayList;

import java.util.List;

/**
 * 啊哈，双指针，简单
 */
public class summaryRanges {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<String>();
        if (nums.length == 0){
            return res;
        }
        //Arrays.sort(nums);
        int i = 0;
        int j = 0;
        while (i < nums.length - 1) {
            if (nums[i] != nums[i + 1] - 1) {
                if (i!=j){
                    StringBuilder sb = new StringBuilder();
                    sb.append(nums[j]).append("->").append(nums[i]);
                    res.add(sb.toString());
                    j = i + 1;
                }
                else {
                    res.add(Integer.toString(nums[i]));
                    j = i + 1;
                }
            }
            i++;
        }
        if (i == j) {
            res.add(Integer.toString(nums[j]));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[j]).append("->").append(nums[i]);
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        summaryRanges sr =new summaryRanges();
        int[] num = {0,2};
        System.out.println(sr.summaryRanges(num));
    }
}
