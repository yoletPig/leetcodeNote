package Contest;
/*
5139. 第 N 个泰波那契数  显示英文描述  我的提交返回竞赛
用户通过次数 688
用户尝试次数 711
通过次数 701
提交次数 1264
题目难度 Easy
泰波那契序列 Tn 定义如下：

T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2

给你整数 n，请返回第 n 个泰波那契数 Tn 的值。

示例 1：

输入：n = 4
输出：4
解释：
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
示例 2：

输入：n = 25
输出：1389537
 */
public class Tribonacci {
    public int tribonacci(int n) {
        int n_0 = 0;
        int n_1 = 0;
        int n_2 = 1;
        int n_3 = 1;
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 1;
        }
        else {
            for (int i = 3; i <= n; i++)
            {
                n_0 = n_1+n_2+n_3;
                n_1 = n_2;
                n_2 = n_3;
                n_3 = n_0;
            }
        }
        return n_0;
    }

    //方法2优化迭代
    public int tribonacci1(int n) {
        int[] res = new int[n+5];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i-1 ] + res[i-2] + res[i-3];
        }
        return res[n];
    }
}
