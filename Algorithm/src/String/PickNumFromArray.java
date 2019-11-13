package String;

/**
 * 398 随机数索引（蓄水池抽样）
 */
public class PickNumFromArray {
    String s;
    public PickNumFromArray(int[] nums){
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        s = sb.toString();
    }
    public int pick (int target){
        return s.indexOf(String.valueOf(target));
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,3,3};
        PickNumFromArray pc = new PickNumFromArray(nums);
        int pick = pc.pick(3);
        System.out.println(pick);
    }
}
