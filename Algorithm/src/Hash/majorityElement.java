package Hash;
import java.util.ArrayList;
import	java.util.HashMap;

import java.util.List;

public class majorityElement {
    /**
     * hash暴力法
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List list = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap<> ();
        for (int num : nums) {
            if (map.containsKey(num)){
                Integer i = map.get(num);
                map.put(num,++i);
            }
            else {
                map.put(num, 1);
            }
            if (map.get(num)>nums.length/3){
                if (!list.contains(num)){
                    list.add(num);
                }
            }
        }
        return list;
    }

    /**
     * 多数投票
     * @param nums
     * @return
     */
    public List<Integer> majorityElement1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
        {
            return res;
        }
        //初始化：定义两个候选人及其对应的票数
        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA = 0;
        int countB = 0;
        //遍历数组
        for (int num : nums) {
            if (num == candidateA) {
                countA++;//投A
                continue;
            }
            if (num == candidateB) {
                countB++;//投B
                continue;
            }

            //此时当前值和AB都不等，检查是否有票数减为0的情况，如果为0，则更新候选人
            if (countA == 0) {
                candidateA = num;
                countA++;
                continue;
            }
            if (countB == 0) {
                candidateB = num;
                countB++;
                continue;
            }
            //若此时两个候选人的票数都不为0，且当前元素不投AB，那么A,B对应的票数都要--;
            countA--;
            countB--;
        }

        //上一轮遍历找出了两个候选人，但是这两个候选人是否均满足票数大于N/3仍然没法确定，需要重新遍历，确定票数
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == candidateA)
            {
                countA++;
            }
            else if (num == candidateB)
            {
                countB++;
            }
        }
        if (countA > nums.length / 3)
        {
            res.add(candidateA);
        }
        if (countB > nums.length / 3)
        {
            res.add(candidateB);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,3,4,4};
        majorityElement me = new majorityElement();
        System.out.println(me.majorityElement1(nums));
    }
}
