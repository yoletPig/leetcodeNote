package Array;

/**
 * 668. 乘法表中第k小的数
 * 难度
 * 困难
 *
 * 39
 *
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 通过次数
 * 931
 * 提交次数
 * 2,347
 */
public class findKthNumber {
    public int findKthNumber(int m, int n, int k) {
        int j;
        int sum = 0;
        int temp = 0;
        for (int i = k/2; i <= n; i++) {
            temp = sum;
            sum = 0;
            j=1;
            while (j<=m){
                sum+=(i/j);
                j++;
            }
            if (k<=sum){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        findKthNumber fn = new findKthNumber();
        System.out.println(fn.findKthNumber(2,3,6));
    }
}
