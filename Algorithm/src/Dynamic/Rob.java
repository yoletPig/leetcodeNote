package Dynamic;
/*
213.打家劫舍2
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums [0];
        }
        if (nums.length == 2){
            return Math.max(nums [0], nums [1]);
        }
        int[] dphead = new int[nums.length];
        int[] dprear = new int[nums.length];
        dphead[0] = nums [0];
        dphead[1] = Math.max(nums [0], nums [1]);
        for (int i = 2; i < nums.length-1; i++) {
            dphead[i] = Math.max(dphead[i-2]+nums [i], dphead[i-1]);
        }
        dprear[1] = nums[1];
        dprear[2] = Math.max(nums [1],nums [2]);
        for (int i = 3; i < nums.length; i++) {
            dprear[i] = Math.max(dprear[i-2]+nums [i], dprear[i-1]);
        }
        return Math.max(dphead[nums.length - 2],dprear[nums.length - 1]);
    }

    public static void main(String[] args) {
        Rob r = new Rob();
        int [] nums = {5,8,10};
        System.out.println(r.rob(nums));
    }
}
