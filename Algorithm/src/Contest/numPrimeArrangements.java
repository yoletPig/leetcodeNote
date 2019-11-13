package Contest;

import java.util.ArrayList;

/**
 * 5173. 质数排列  显示英文描述  我的提交返回竞赛
 * 用户通过次数 488
 * 用户尝试次数 598
 * 通过次数 500
 * 提交次数 1272
 * 题目难度 Easy
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」上；你需要返回可能的方案总数。
 *
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 *
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 * 示例 2：
 *
 * 输入：n = 100
 * 输出：682289015
 *
 */

public class numPrimeArrangements {
    public int numPrimeArrangements(int n) {
        int a = pr(n);
        int b = n - a;
        long s = 1;
        for (int i = 1; i <= a; i++) {
            s*=i;
            s%=1000000007;
        }
        for (int i = 1; i <= b; i++) {
            s*=i;
            s%=1000000007;
        }
        return (int)s;
    }
    public int pr (int n ){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            int j = 2;
            while(j<=Math.sqrt(i)){
                if (i%j==0){
                    break;
                }
                j++;
            }
            if (j>Math.sqrt(i)){
                list.add(i);
            }
        }
        return list.size();
    }



    public int numPrimeArrangements1(int n) {

        boolean f[] = new boolean[n+1];
        f[1] = true;

        for(int i=2;i<=n;++i){
            for(int j=2;j<i;++j){
                if(i%j==0){
                    f[i] = true;
                    break;
                }
            }

        }
        int c =0;
        for(int i=1;i<=n;++i){
            if(!f[i]){
                c++;
            }
        }
        int nc = n-c;
        long p  = 1000000007L;
        long s = 1;
        for(long i=1;i<=c;++i){
            s *= i;
            s %= p;
        }
        for(long i=1;i<=nc;++i){
            s *= i;
            s %= p;
        }
        return (int)s;

    }
    public static void main(String[] args) {
        numPrimeArrangements n = new numPrimeArrangements();
        System.out.println(n.numPrimeArrangements(100));
    }
}
