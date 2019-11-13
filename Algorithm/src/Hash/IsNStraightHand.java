package Hash;

import java.util.Map;
import java.util.TreeMap;

public class IsNStraightHand {
    //耗时很高。。
    public boolean isNStraightHand(int[] hand, int W) {
        //如果不是w的倍数肯定返回false
        if (hand.length%W!=0){
            return false;
        }
        //利用TreeMap的自动排序性解题；
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int j = 0;
        //存数据
        for (int i : hand) {
            if (treeMap.containsKey(i)){
                treeMap.put(i,treeMap.get(i) + 1) ;
            }
            else {
                treeMap.put(i, 1);
            }
        }

        while (treeMap.size()!= 0 ){
            int[] temp = new int[W];
            //拿到最小元素
            int min = treeMap.firstKey();
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                //更新集合
                if (entry.getValue() == 0){
                    treeMap.remove(entry.getKey());
                    break;
                }
                if (entry.getValue()!=0){
                    treeMap.put(entry.getKey(),entry.getValue()-1);
                }
                if (entry.getKey()-min>=W){
                    return false;
                }
                //设置数组用于判断是否连续
                temp[entry.getKey()-min]+=1;
                if (temp[entry.getKey()-min]>1){
                    return false;
                }
                j++;
                //分组后， 如果数组有0 ，则false；
                if (j%W == 0){
                    for (int i : temp) {
                    if (i==0){
                        return false;
                    }
                }
                    break;
                }
            }

        }

        return true;
    }

    //---------**------------------**--------------错误写法

    public boolean isNStraightHand1(int[] hand, int w) {
        if(hand.length % w != 0)
        {
            return false;
        }
        int[] array = new int[w];
        for (int i : hand) {
            array[i % w]++;
        }
        for(int i = 0; i < w - 1; i++) {
            //若是顺子，array的每一元素理应是相等的
            if(array[i] != array[i+1])
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,7,8,12,16,20};
        int w = 3;
        IsNStraightHand is = new IsNStraightHand();
        System.out.println(is.isNStraightHand1(hand, w));
    }
}
