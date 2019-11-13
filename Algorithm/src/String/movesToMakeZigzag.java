package String;

public class movesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int odd = 0;
        int eve = 0;
        //偶数最高
        for (int i = 0; i < nums.length; i+=2) {
            int temp = 0;
            if(i ==0){
               temp = nums [1];
            }else if (i==nums.length -1){
                temp= nums[nums.length -2];
            }else {
                temp = nums [i-1]>nums[i+1]?nums[i+1]:nums [i-1];
            }
            if(temp<=nums[i]){
                eve+=nums[i]-temp+1;
            }
        }

        //奇数最高
        for (int i = 1; i < nums.length; i+=2) {
            int temp = 0;
           if (i==nums.length -1){
                temp= nums[nums.length -2];
            }else {
                temp = nums [i-1]>nums[i+1]?nums[i+1]:nums [i-1];
            }
            if(temp<=nums[i]){
                odd+=nums[i]-temp+1;
            }
        }

        return eve>odd?odd:eve;
    }

    public static void main(String[] args) {
        movesToMakeZigzag mtm = new movesToMakeZigzag();
        int[] nums = {10,4,4,10,10,6,2,3};
        System.out.println(mtm.movesToMakeZigzag(nums));
    }
}
