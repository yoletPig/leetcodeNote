package Array;

import java.util.*;

public class findRightInterval {
    /**
     * 哈希表+排序+扫描
     * @param intervals
     * @return
     */
    public int[] findRightInterval_115ms(int[][] intervals) {
        //存右区间的下标
        ArrayList<Integer> list = new ArrayList<>();
        //存下标
        HashMap<int[],Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i],i);
        }
        //从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        //扫描寻找右区间
        for (int i = 0; i < intervals.length-1; i++) {
            int[] t_i = intervals[i];
            int[] t_j;
            int j = i+1;
            while (j<intervals.length){
                t_j = intervals[j];
                if (t_j[0]>=t_i[1]){
                    break;
                }
                j++;
            }
            if (j<intervals.length){
                list.add(map.get(intervals[j]));
            }else {
                list.add(-1);
            }
        }
        list.add(-1);
        //将list集合中的值取出；
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[map.get(intervals[i])] = list.get(i);
        }
        return res;
    }


    public int[] findRightInterval_24ms(int[][] intervals) {
        //存下标
        HashMap<int[],Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i],i);
        }
        //从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        int [] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int[] arr = binarySearch(intervals,intervals[i][1],0,intervals.length - 1);
            res[map.get(intervals[i])] = arr==null?-1:map.get(arr);
        }
        return res;
    }

    private int[] binarySearch(int[][] intervals, int target, int begin, int end){
        if (begin>=end){
            if (intervals[begin][0]>=target){
                return intervals[begin];
            }
            return null;
        }
        int mid = (begin+end)/2;
        if (intervals[mid][0]>=target){
            return binarySearch(intervals,target,begin,mid);
        }else {
            return binarySearch(intervals, target, mid+1, end);
        }
    }

    public static void main(String[] args) {
        findRightInterval f = new findRightInterval();
        int[][] intervals = {{1,12},{2,9},{3,10},{13,14},{15,16},{16,17}};
        int[] rightInterval = f.findRightInterval_24ms(intervals);
        System.out.println(Arrays.toString(rightInterval));
    }
}
