package Contest;

import java.util.*;

/**
 * 百度之星：度度熊与数字
 * 度熊发现，11, 33 以及 99 这三个数字很神奇，它们的所有的倍数的每位数字的和一定是自己的倍数。例如说: 5454 是 33 的倍数，同时 5+4 = 95+4=9 也是 33 的倍数。在另一个例子 666666 是 99 的倍数，同时 6+6+6 = 186+6+6=18 也是 99 的倍数。
 *
 * 度熊又发现，除了 11, 33, 99 以外的的正整数，虽然并不满足"所有的倍数的每位数字的和一定是自己的倍数"，但也存在一些数是它们的倍数且各位数字和也是它们的倍数。例如说，888888 是 1212 的倍数，且他的各位数字和 8+8+8=248+8+8=24 也是 1212 的倍数。
 *
 * 现在度熊想知道，给你一个正整数 VV，是否存在一个数 xx，使得 VV 是 xx 的倍数，同时它的每位数字的和也是 xx 的倍数呢?请找出所有这样的数 xx。
 *
 * Input
 * 有多组询问，第一行包含一个正整数 TT 代表有几组询问，接着每组测试数据占一行，包含一个正整数 VV。
 *
 * 1 \le T \le 1001≤T≤100
 *
 * 1 \le V \le 10^91≤V≤10
 * ​9
 * ​​
 *
 * Output
 * 对于每一个询问，输出两行，第一行包含一个正整数 mm，mm 代表对于该询问的 VV，有几个满足条件的 xx。第二行输出 mm 个数，把所有满足条件的 xx 由小到大输出。
 *
 * Sample Input
 * 3
 * 1
 * 9
 * 666666
 * Sample Output
 * Copy
 * 1
 * 1
 * 3
 * 1 3 9
 * 6
 * 1 2 3 6 9 18
 *
 * Note
 * 第一个询问中，11 的各位数和为 1 = 1 \times 11=1×1，本身等于 1 \times 11×1 都是 11 的倍数，故 11 确实为 V=1V=1 的答案。
 *
 * 第三个询问中，666666666666 的各位数和为 36 = 9 \times 436=9×4，本身等于 9 \times 74749×7474 都是 99 的倍数，故 99 确实为 V=666666V=666666 的答案，经过仔细计算后能发现，除 99 以外, 1,2,3,6,181,2,3,6,18 也都是答案。
 */
public class BaiduNum {
    public List superPow(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int temp = num;
        while (num!=0){
            list.add(num%10);
            num /= 10;
        }
        int sum = 0;
        for (Integer i : list) {
            sum+=i;
        }
        set.add(1);
        set.add(sum);
        int i = 2;
        while (i<=Math.sqrt(sum)){
            if (sum%i==0){
                set.add(i);
                set.add(sum/i);
            }
            i++;
        }
        list.removeAll(list);
        for (Integer j : set) {
            if (temp%j==0){
                list.add(j);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BaiduNum sp = new BaiduNum();
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : arr) {
            List list = sp.superPow(i);
            Collections.sort(list);
            System.out.println(list.size());
            for (int i1 = 0; i1 < list.size()-1; i1++) {
                System.out.print(list.get(i1)+" ");
            }
            System.out.println(list.get(list.size()-1));
        }
    }
}
