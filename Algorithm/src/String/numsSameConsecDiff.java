package String;

import java.util.ArrayList;
import java.util.Arrays;

public class numsSameConsecDiff {
    ArrayList<Integer> list = new ArrayList<>();
    public int[] numsSameConsecDiff(int N, int K) {
        if (N==1){
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }
        for (int i = 1; i <= 9; i++) {
        f(new StringBuilder(),i,N,K);
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            res[i] = integer;
            i++;
        }
        return res;
    }
    /*
    递归心得：第一，递归出口不止一个，我们可以通过画图来来发现递归出口，
    第二，对于每次递归需要选择不同的值，记得如果是对象的话不能直接赋值，
    需要new出来再赋值，应该是递归的时候调用不同的地址才可以用回原来的值。
     */
    private void f(StringBuilder sb, int num, int N ,int K){
        if (sb.length()==N ){
            if (!list.contains(Integer.parseInt(sb.toString()))){
                list.add(Integer.parseInt(sb.toString()));
            }
            return;
        }
        if (num>=0&&num<=9){
            sb.append(num);
        }else {
            return;
        }
        StringBuilder temp = new StringBuilder(sb.toString());
        f(sb,num+K, N, K);
        sb=temp;
        f(sb,num-K, N, K);
}
    public static void main(String[] args) {
        numsSameConsecDiff ns = new numsSameConsecDiff();
        System.out.println(Arrays.toString(ns.numsSameConsecDiff(3,3)));
    }
}




















