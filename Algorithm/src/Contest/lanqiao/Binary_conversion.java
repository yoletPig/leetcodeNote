package Contest.lanqiao;

import java.util.*;

public class Binary_conversion {
    void fun(){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        String a = in.next();
        String b = in.next();
        HashMap<Character,Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        String temp = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < temp.length(); i++) {
            map.put(temp.charAt(i),i);
            list.add(temp.charAt(i));
        }
        String s_MaxLen = a;
        String s_MinLen = b;
        if (a.length()<b.length()){
            s_MaxLen = b;
            s_MinLen = a;
        }
        int len = s_MaxLen.length()-s_MinLen.length();
        char[] chars = new char[s_MaxLen.length()+1];
        boolean flag = false;
        for (int i = s_MaxLen.length()-1; i >= 0; i--) {
            if(i>=len){
                char s1 = s_MaxLen.charAt(i);
                char s2 = s_MinLen.charAt(i-len);
                int t_sum = map.get(s1)+map.get(s2);
                if (t_sum>=k){
                    if (i!=0)
                    {
                        char t_c = s_MaxLen.charAt(i-1);
                        t_c+=1;
                        char[] array = s_MaxLen.toCharArray();
                        if (t_c==':'){
                            t_c = 'A';
                        }
                        array[i-1] = t_c;
                        s_MaxLen = String.valueOf(array);
                    }
                    else {
                        t_sum%=k;
                        chars[0] = list.get(t_sum);
                        flag = true;
                    }
                }
                t_sum%=k;
                chars[i+1] = list.get(t_sum);
            }
            else {
                chars[i+1] = list.get(map.get(s_MaxLen.charAt(i)));
            }
        }
        String res = String.valueOf(chars);
        if (!flag){
            res = res.substring(1);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Binary_conversion m = new Binary_conversion();
        m.fun();
    }
}
