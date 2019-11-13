package Contest.lanqiao;

import java.util.*;


public class ins_eat_cal {
    int n;
    String a;
    String b;
    String c;

    void fun() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        a = in.next();
        b = in.next();
        c = in.next();
        dfs(false,n-1,new HashMap<Character, Integer>(),new ArrayList<Integer>());
    }

    private void dfs(boolean flag, int pos, Map<Character, Integer> map, List<Integer> list) {
        if (pos<0){
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey()+"->"+entry.getValue());
            }
            System.out.println("++++++++++++++");
        }
        if (pos>=0){
            char c1 = a.charAt(pos);
            char c2 = b.charAt(pos);
            char c3 = c.charAt(pos);
            //给c1，c2赋值
            for (int i = 0; i < n; i++) {
                if (!map.containsKey(c1)&&!list.contains(i)){
                    map.put(c1,i);
                    list.add(i);
                }
                for (int j = 0; j < n; j++) {
                    if (!map.containsKey(c2)&&!list.contains(j)){
                        map.put(c2,j);
                        list.add(j);
                    }
                    if (map.containsKey(c2)&&map.containsKey(c1)){
                        int t_sum = map.get(c1) + map.get(c2);
                        boolean t_flag = false;
                        //是否要进1
                        if (flag) {
                            if (t_sum + 1 >= n) {
                                t_flag = true;
                            }
                            t_sum = (t_sum + 1) % n;
                        } else {
                            if (t_sum >= n) {
                                t_flag = true;
                            }
                            t_sum %= n;
                        }
                        //判断c3存不存在
                        if (!map.containsKey(c3)) {
                            if (!list.contains(t_sum)) {
                                list.add(t_sum);
                                map.put(c3, t_sum);
                            }
                        }
                        if (map.containsKey(c3)&&t_sum == map.get(c3)) {
                            dfs(t_flag, --pos, map, list);
                        }
                        else {
                            list.remove(map.get(c2));
                            map.remove(c2);
                        }
                    }
                    if (j==n-1){
                        list.remove(map.get(c1));
                        map.remove(c1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ins_eat_cal m = new ins_eat_cal();
        m.fun();
    }
}
