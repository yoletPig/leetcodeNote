package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class eraseOverlapIntervals {
    int len = 1;
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length ==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            temp = add(temp, intervals[i]);
        }
        return intervals.length-len;
    }

    private int[] add(int[] a, int[] b) {
        int ax = a[0];
        int ay = a[1];
        int bx = b[0];
        int by = b[1];
        int[] te = new int[2];
        if (ax == bx){
            te[0] = ax;
            te[1] = ay>=by?by:ay;
        }
        else {
            if (by<=ay){
                te[0] = bx;
                te[1] = by;
            }
            else {
                if (bx >= ay){
                    te[0] = bx;
                    te[1] = by;
                    len++;
                }
                else {
                    te[0] = ax;
                    te[1] = ay;
                }
            }
        }
        return te;
    }

    public static void main(String[] args) {
        eraseOverlapIntervals era = new eraseOverlapIntervals();
        int[][] inter = {{1,2},{2,3},{3,4},{4,5}};
        System.out.println(era.eraseOverlapIntervals(inter));
    }
}
