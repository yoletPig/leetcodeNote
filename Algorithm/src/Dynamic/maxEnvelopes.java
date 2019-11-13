package Dynamic;

import java.util.*;

/**
 * 354. 俄罗斯套娃信封问题
 */
public class maxEnvelopes {
    public int maxEnvelopes1(int[][] envelopes) {
        List<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < envelopes[i].length; j++) {
                list.add(envelopes[i][j]);
            }
            lists.add(list);
        }
        //System.out.println(lists);
        Collections.sort(lists, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int i = o1.get(0) - o2.get(0);
                if (i == 0) {
                    i = o1.get(1) - o2.get(1);
                }
                return i;
            }
        });
        //System.out.println(lists);
        int[] dp = new int[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            int j = 0;
            ArrayList<Integer> ilist = lists.get(i);
            while (j < i) {
                ArrayList<Integer> jlist = lists.get(j);
                if (ilist.get(0) > jlist.get(0) && ilist.get(1) > jlist.get(1)) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
                j++;
            }
            dp[i] += 1;
        }
        //System.out.println(Arrays.toString(dp));
        int max = 0;
        for (int i : dp) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    //---------------------

    public int maxEnvelopes(int[][] envelopes){
        Arrays.sort(envelopes,new Comparator < int [] > () {
            @Override
            public int compare(int [] o1, int [] o2) {
                int i = o1 [0] - o2 [0];
                if (i==0){
                    i = o1 [1] - o2 [1];
                }
                return i;
            }
        });
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < dp.length; i++) {
            int j = 0;
            while (j < i) {
               if (envelopes[i][0]>envelopes[j][0]&&envelopes[i][1]>envelopes[j][1]){
                   dp[i] = Math.max(dp[i],dp[j]);
               }
                j++;
            }
            dp[i] += 1;
        }
        //System.out.println(Arrays.toString(dp));
        int max = 0;
        for (int i : dp) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        maxEnvelopes me = new maxEnvelopes();
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int i = me.maxEnvelopes(envelopes);
    }
}
