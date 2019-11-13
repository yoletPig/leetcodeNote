package Hash;

import java.util.HashMap;
import java.util.HashSet;
/*
575 分糖果
给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果
你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 */
public class DistributeCandies {
    public int distributeCandies1(int[] candies) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < candies.length; i++) {
            if (map.containsKey(candies[i])){
                int count = map.get(candies[i]);
                map.put(candies[i],count++);
            }
            else {
                map.put(candies[i],1);
            }
        }
        int count = 0;
        int sum = 0;
        for (Integer in : map.keySet()) {
            count++;
            sum+=map.get(in);
            if (sum>=candies.length/2&&count<=map.size()/2)
            {
                return candies.length-count;
            }
            if (sum>=candies.length/2&&count>=map.size()/2)
            {
                return candies.length-count;
            }
        }
        return count;
    }
    //-----------------华丽的分割线------------------------
    public int distributeCandies2(int[] candies){
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
            if (!set.contains(candy)){
                set.add(candy);
            }
        }
        return set.size()>candies.length/2?candies.length/2:set.size();
    }
//-----------------华丽的分割线------------------------
    public int distributeCandies3(int[] candies) {
        int max = candies[0] ,min = candies[0];
        for(int i = 1 ; i < candies.length ; i++){
            min = Math.min(min , candies[i]);
            max = Math.max(max , candies[i]);
        }
        boolean [] flag = new boolean[max - min + 1];
        int ans = 0;
        for(int i : candies){
            if(!flag[i - min]){
                ans++;
                flag[i - min] = true;
            }
        }
        int len = candies.length >> 1;
        return ans > len ? len : ans;

    }
/*
总结：这就类似点脑筋急转弯，2，3的解题方法更像是思维逻辑题，
当糖果种类大于糖果数的一半时就返回的是糖果种类的数量，
否则就返回糖果数的一半；虽然思路一样，但可以看出使用hash函数还是会慢了不少；
 */
    public static void main(String[] args) {
        DistributeCandies distributeCandies = new DistributeCandies();
        int[] ca = {1,1,2,3};
        System.out.println(distributeCandies.distributeCandies3(ca));
    }
}
