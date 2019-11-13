package Array;

import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       ArrayList<Integer> res = new ArrayList<Integer> ();
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i]-1)%nums.length]+=nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums [i] <= nums.length){
                res.add(i+1);
            }
        }
        return res;
    }


    //448 利用异或交换位置
    public List<Integer> findDisappearedNumbers4(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }

    public static void main(String[] args) {
        findDisappearedNumbers fd = new findDisappearedNumbers();
        int[] nums = {4,3,2,7,8,1,2,3};
        System.out.println(fd.findDisappearedNumbers(nums));
    }
}
