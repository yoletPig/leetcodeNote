package MoveOperation;

import java.util.Arrays;

/*
338 比特位计数
总结：位运算中 >> 相当于/2，最后1位是用来判断奇偶数的，1位奇，
0为偶；
方法1： 左移，每次&1，=1时count++；
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] arr = new int[num+1];
        for (int i = 0; i < num+1; i++) {
            int count =0;
            int k = i;
            for (int j = 0; j < 32; j++) {
                if ((k&1)==1){
                    count++;
                }
                k>>=1;
            }
            arr[i] = count;
        }
        return arr;
    }

    //方法2 n&(n-1) 方法1的优化版本，更快计算出 二进制中1的个数；

    public int[] countBits1(int num) {
        int[] arr = new int[num+1];
        for (int i = 0; i < num+1; i++) {
            int count =0;
            int k = i;
            while (k!=0){
                k=k&(k-1);
                count++;
            }
            arr[i] = count;
        }
        return arr;
    }

    //方法3动态规划：最高位前加1 得状态转移方程：arr[i+b] = arr[i]+1;b=2^m>i;

    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;
            // reset i
            b <<= 1;
            // b = 2b
        }
        return ans;
    }

    //方法4动态规划，最低位，一个数>>1时，如果是奇数，那么它的1的数量就会减1，如果是偶数就不变，
    //所以状态转移方程为：arr[i] = arr[i>>1] + i mod 2;

    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
        {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }

     public static void main(String[] args) {
        CountBits c = new CountBits();
        int[] a = c.countBits1(10);
        System.out.println(Arrays.toString(a));
    }
}
