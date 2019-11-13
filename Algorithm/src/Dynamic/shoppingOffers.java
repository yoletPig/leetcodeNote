package Dynamic;

import java.util.ArrayList;
import java.util.List;

public class shoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int Min = Integer.MAX_VALUE;
        List<Integer> Min_list;
        boolean flag = true;
        int total = 0;
        int t_total = 0;
        for (int i = 0; i < needs.size(); i++) {
            t_total+=needs.get(i)*price.get(i);
        }
        while (flag){
            Min_list = new ArrayList<>();
            //对礼包进行dp，找到最小价格列表
            for (List<Integer> list : special) {
                int i = 0;
                int sum = 0;
                for (; i < needs.size(); i++) {
                    if (needs.get(i)<list.get(i)){
                        sum = 0;
                        break;
                    }
                    sum += (needs.get(i)-list.get(i))*price.get(i);
                }
                if (i==needs.size()){
                    sum+=list.get(i);
                    if (sum<Min){
                        Min_list = list;
                        Min = sum;
                    }
                }
            }
            if (Min_list.size()<1){
                flag = false;
                break;
            }else {
                total+=Min_list.get(Min_list.size() - 1);
            }
            //减去最小Min_list得当前需要买的数目，继续循环。
            for (int i = 0; i < needs.size(); i++) {
                needs.set(i,needs.get(i)-Min_list.get(i));
            }
        }
        for (int i = 0; i < needs.size(); i++) {
            total+=needs.get(i)*price.get(i);
        }
        return total<t_total?total : t_total;
    }

    public static void main(String[] args) {
        shoppingOffers s_s = new shoppingOffers();
        List<Integer> price = new ArrayList<>();
        List<Integer> needs = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<List<Integer>> sp = new ArrayList<>();
        price.add(2);
        price.add(5);
        needs.add(6);
        needs.add(4);
        list.add(3);
        list.add(0);
        list.add(5);
        sp.add(list);
        list1.add(1);
        list1.add(2);
        list1.add(10);
        sp.add(list1);
        int i = s_s.shoppingOffers(price, sp, needs);
        System.out.println(i);
    }
}
