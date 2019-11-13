package Contest;

import java.util.*;

public class NumEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<ArrayList<Integer>,Integer> set = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            Collections.addAll(list,dominoes[i][0],dominoes[i][1]);
            Collections.sort(list);
            int count = 1;
            if (set.containsKey(list)){
                count = set.get(list)+1;
                set.put(list,count);
            }
            else {
                set.put(list,1);
            }
        }
        int sum = 0;
        for (Map.Entry<ArrayList<Integer>, Integer> Entry : set.entrySet()) {
            int V = Entry.getValue();
            if (V>1){
                sum += V*(V-1)/2;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{1,1},{1,2},{1,2},{2,2}};
        System.out.println(new NumEquivDominoPairs().numEquivDominoPairs(arr));
    }
}
