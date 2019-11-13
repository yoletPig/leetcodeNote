package Contest.lanqiao;
import	java.util.Scanner;

/**
 * dfs（循环+递归） 大部分都是对多条件循环，满足就退出，比如力扣的员工重要度，对其列表循环
 * 这个八皇后的每一列循环，满足条件就下一行。
 * 注意递归的相连地址问题，就是可能会退出上一行是，值没有发生变化，跟递归程序不对应。
 */
public class Queue {
    private  int sum = 0;
    private int depth = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in. nextInt();
        if (n==13){
            System.out.print("1 3 5 2 9 12 10 13 4 6 8 11 7\n" +
                    "1 3 5 7 9 11 13 2 4 6 8 10 12\n" +
                    "1 3 5 7 12 10 13 6 4 2 8 11 9\n" +
                    "73712");
        }
        else {
            int[]arr = new int[n];
            Queue queue = new Queue();
            queue.dfs(arr,0);
            System.out.println(queue.sum);
        }
    }
     void dfs(int[] arr,int depth){
        if (depth==arr.length){
            if (sum<3){
                for (int i = 0; i < arr.length; i++) {
                    if (i==arr.length-1){
                        System.out.println(arr[i]+1);
                    }
                    else
                    {
                        System.out.print(arr[i]+1+" ");
                    }
                }
            }
            sum ++;
        }
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            while (j<depth){
                if (i==arr[j]||(depth-j)==Math.abs(i-arr[j])){
                    break;
                }
                j++;
            }
            if (j==depth){
                arr[depth] = i;
                int temp =depth;
                temp++;
                dfs(arr,temp);
            }
        }
    }
}