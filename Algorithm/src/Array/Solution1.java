package Array;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1 {
        int[] nums;
        public Solution1(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int num : this.nums) {
                list.add(num);
            }
            Collections.shuffle(list);
            int[] nums = new int [list.size()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = list.get(i);
            }
            return nums;
        }
    }

