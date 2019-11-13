package Dynamic;

import java.util.Arrays;

public class intervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int[][] arr = new int[A.length+B.length][2];
        int j = 0;
        int i = 0;
        int k = 0;
        while (i<A.length&&j<B.length){
            //前
            if (B[j][0]<A[i][0]){
                //尾前
                if (B[j][1]<A[i][0]){
                    j++;
                    continue;
                }
                //尾中跟后
                if (B[j][1]>=A[i][0]){
                    //尾后
                    if (B[j][1]>A[i][1]){
                        arr[k][0] = A[i][0];
                        arr[k][1] = A[i][1];
                        i++;
                        k++;
                        continue;
                    }
                    //尾中
                    else {
                        arr[k][0] = A[i][0];
                        arr[k][1] = B[j][1];
                        k++;
                        j++;
                        continue;
                    }
                }
            }
            //中
           else if (B[j][0]>=A[i][0]&&B[j][0]<=A[i][1]){
                //尾后
                if (B[j][1]>A[i][1]){
                    arr[k][0] = B[j][0];
                    arr[k][1] = A[i][1];
                    k++;
                    i++;
                }
                //尾中
                else {
                    arr[k][0] = B[j][0];
                    arr[k][1] = B[j][1];
                    k++;
                    j++;
                }
            }
            //后
            else {
                i++;
            }
        }
        int[][] res = new int[k][2];
        for (int z = 0; z < res.length; z++) {
            res[z] = arr[z];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] A = {{3,5},{9,20}};
        int[][] B = {{4,5},{7,10},{11,12},{14,15},{16,20}};
        intervalIntersection in = new intervalIntersection();
        int[][] ints = in.intervalIntersection(A, B);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

    }
}
