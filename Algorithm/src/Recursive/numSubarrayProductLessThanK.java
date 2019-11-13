package Recursive;

public class numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        double logk = Math.log(k);
        double[] prefix = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i+1] = prefix[i] + Math.log(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < prefix.length; i++) {
            int lo = i + 1, hi = prefix.length;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (prefix[mi] < prefix[i] + logk - 1e-9) {
                    lo = mi + 1;
                }
                else {hi = mi;}

            }
            ans += lo - i - 1;
        }
        return ans;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k){
        int count = 0;
        double logk = Math.log(k);
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            double mulJ = 0;
            while (mulJ<logk&&j<nums.length){
                mulJ+=Math.log(nums[j]);
                if (mulJ<logk-1e-9){
                    count++;
                }
                j++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int [] nums = {10,3,3,7,2,9,7,4,7,2,8,6,5,1,5};
        numSubarrayProductLessThanK n = new numSubarrayProductLessThanK();
        System.out.println(n.numSubarrayProductLessThanK(nums,30));
    }
}
