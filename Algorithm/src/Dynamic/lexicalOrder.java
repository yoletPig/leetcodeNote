package Dynamic;

import java.util.ArrayList;
import java.util.List;

public class lexicalOrder {
    /**
     *
     * @param n 代表1到n这n个数
     * @return 返回字典序排数 [1,10,11,12,2,3,4,5,6,7,8,9]
     *
     * 原理：按照字典序原理动态实现返回集合;
     * 字典序原理：每一位是最小，从左往右依次增大；
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur=1;
        for(int i=0;i<n;i++){
            res.add(cur);
            if(cur*10<=n){
                cur*=10;
            }else{
                if(cur>=n){
                    cur/=10;
                }
                cur+=1;
                while(cur%10==0) {
                    cur/=10;
                }
            }
        }
        return res;
    }
}
