package Array;

/**
 * 962 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 *
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 *
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 *
 */
public class maxWidthRamp {
    public int maxWidthRamp1(int[] A) {
        int maxL = 0;
        int temp = Integer.MIN_VALUE;
        for (int j = A.length - 1; j - maxL > 0; j--) {
            if (A[j]<=temp){
                continue;
            }
            temp = A[j];
            int i =0;
            while (i<j){
                if (A[i]<=A[j]){
                    if (j-i>maxL)
                    {
                        maxL = j-i;
                    }
                    break;
                }
                i++;
            }
        }
        return maxL;
    }


        public int maxWidthRamp(int[] A) {
            if(A==null || A.length<=1){
                return 0;
            }
            int[] min=new int[A.length];
            int[] max=new int[A.length];
            min[0]=A[0];
            max[A.length-1]=A[A.length-1];
            for(int i=1;i<A.length;i++){
                min[i]=Math.min(A[i],min[i-1]);
            }
            for (int i = A.length-2; i >=0 ; i--) {
                max[i]=Math.max(A[i],max[i+1]);
            }
            int i=0;
            int j=0;
            int result=0;
            while (i<A.length && j<A.length){
                if(min[i]<=max[j]){
                    result=Math.max(j-i,result);
                    j++;
                }else{
                    i++;
                }
            }
            return result;
        }

    public static void main(String[] args) {
        maxWidthRamp mwr = new maxWidthRamp();
        int[] A = {9,8,7,2,3,1,9,4,0,4,1};
        System.out.println(mwr.maxWidthRamp(A));
    }
}
