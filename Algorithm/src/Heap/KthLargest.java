package Heap;

import java.util.PriorityQueue;

public class KthLargest {
    final PriorityQueue<Integer> minheap;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minheap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
//        minheap.offer(val);
//        return minheap.peek();
        if (minheap.size() < k) {
            minheap.offer(val);
        } else if (minheap.peek() < val) {
            minheap.poll();
            minheap.offer(val);
        }
        return minheap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        KthLargest k = new KthLargest(3, nums);
        System.out.println(k.add(1));
    }
}
