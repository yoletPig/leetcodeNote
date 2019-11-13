package Hash;
import java.util.*;

@SuppressWarnings("all")
public class maxPoints {
    public int maxPoints1(int[][] points) {
        //获取二维数组的不重复的数组和它的个数；
        HashMap<List<Integer>,Integer> countmap = new HashMap<> ();
        for (int i = 0; i < points.length; i++) {
            ArrayList<Integer> list = new ArrayList<> ();
            list.add(points [i] [0]);
            list.add(points [i] [1]);
            if (countmap.containsKey(list)){
                Integer in = countmap.get(list);
                countmap.put(list, in + 1);
            }
            else {
                countmap.put(list, 1);
            }
        }
        if (countmap.size()==0){
            return 0;
        }
        if (countmap.size()==1||countmap.size()==2){
            return points.length;
        }
        int max = 0;
        int i0 = 0;
        int i1 = 0;
        int n = 0;
        ArrayList<List<Integer>> List = new ArrayList<> ();
        int[] num = new int [countmap.size()];
        HashMap<Double, Integer> map = new HashMap<> ();
        for (Map.Entry<List<Integer>, Integer> entry : countmap.entrySet()) {
            List.add(entry.getKey());
            num[n] = entry.getValue();
            n++;
        }
        for (int i = 1; i < List.size(); i++) {
            i0 = List.get(i).get(0);
            i1 = List.get(i).get(1);
            int j = 0;
            int j0;
            int j1;
            double k;
            HashMap<Double, Integer> kmap = new HashMap<> ();
            while (j<i){
                j0 = List.get(j).get(0);
                j1 = List.get(j).get(1);
                if (i0==j0){
                    k=Integer.MAX_VALUE;
                }else {
                    if (i1 == j1){
                        k=0;
                    }else
                    {
                        k =(double) (i1 - j1) / (i0 - j0);
                    }
                }
                if (!kmap.containsKey(k)){
                    kmap.put(k, j);
                }
                j++;
            }
            for (Map.Entry<Double, Integer> doubleIntegerEntry : kmap.entrySet()) {
                if (map.containsKey(doubleIntegerEntry.getKey())){
                    Integer integer = map.get(doubleIntegerEntry.getKey());
                    map.put(doubleIntegerEntry.getKey(),integer+num[i]);
                }
                else {
                    map.put(doubleIntegerEntry.getKey(), num[i]+num[doubleIntegerEntry.getValue()]);
                }
                if (map.get(doubleIntegerEntry.getKey())>max){
                    max = map.get(doubleIntegerEntry.getKey());
                }
            }
        }

        return max;
    }

    public int maxPoints(int[][] points){
        return 0;
    }
    public static void main(String[] args) {
        maxPoints mp = new maxPoints();
        //int[][] points = {{0,-12},{5,2},{2,5},{0,-5},{1,5},{2,-2},{5,-4},{3,4},{-2,4},{-1,4},{0,-5},{0,-8},{-2,-1},{0,-11},{0,-9}};
        int[][] points ={{1,1},{2,1},{1,-1},{2,-1}};
        System.out.println(mp.maxPoints(points));
    }
}
