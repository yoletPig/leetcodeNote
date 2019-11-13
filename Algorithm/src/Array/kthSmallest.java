package Array;
import java.util.Comparator;
import	java.util.PriorityQueue;

import java.util.Arrays;

/**
 *
 会员中心
 8


 378. 有序矩阵中第K小的元素
 难度
 中等

 97


 收藏

 分享
 切换为英文
 通过次数
 8,366
 提交次数
 14,757
 题目描述
 评论 (86)
 题解(12)New
 提交记录
 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 请注意，它是排序后的第k小元素，而不是第k个元素。

 示例:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],k = 8,

 返回 13。
 */
public class kthSmallest {
    //暴力
    public int kthSmallest1(int[][] matrix, int k) {
        int z= 0;
        int[] res = new int [matrix.length*matrix [0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res[z] = matrix [i] [j];
                z++;
            }
        }
        Arrays.sort(res);
        return res [k-1];
    }
    //优先队列
    int k;
    PriorityQueue<Integer> pq = null;

    public int kthSmallest2(int[][] matrix, int k){
        this.k = k;
        pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                add(matrix [i] [j]);
            }
        }
        return pq.peek();
    }

    private void add(int matrix) {
        if (pq.size()<k){
            pq.add(matrix);
        }else {
            if (matrix<pq.peek()){
                pq.poll();
                pq.add(matrix);
            }
        }
    }

    //二分
    public int kthSmallest(int[][] matrix, int k){
        int left = matrix [0][0];
        int right = matrix [matrix.length - 1][matrix[0].length-1];
        while (left<right){
            int mid = (left+right)/2;
            int count = find(matrix, mid);
            if (count<k){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return right;
    }

    private int find(int[][] matrix, int mid) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[i].length-1]<=mid){
                count+=matrix [i].length;
                continue;
            }
            for (int length = matrix[i].length-1; length >= 0; length--) {
                if (matrix[i][length]>mid){
                    continue;
                }
                else {
                    count += length+1;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        kthSmallest ks = new kthSmallest();
        int [] [] matrix = {{1, 3, 5},{6, 7, 12},{11, 14, 14}};
        System.out.println( ks.kthSmallest(matrix,3));
    }
}
