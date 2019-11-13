package String;

import java.util.ArrayList;

public class isAdditiveNumber {
    int cur = 0;
    String a = "";
    String b = "";
    boolean fuck = false;
    ArrayList<String[]> list;
    public boolean isAdditiveNumber(String num) {
        next(num);
        if (a.length()==0){
            return false;
        }
        String add;
        while (cur<num.length()){
            add = addstrcat(a,b);
            if (num.length()-cur<add.length()||fuck){
                return false;
            }
            String c = num.substring(cur,cur+add.length());
            if (add.equals(c)){
                a = b;
                b = c;
                cur+=c.length();
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    /**
     * 输入两个字符串 a，b 返回字符串数值相加后的新字符串
     * @param a 数字类型的字符串
     * @param b 数字类型的字符串
     * @return 返回字符串数值相加后的新字符串
     */
    public String addstrcat(String a,String b){
        long l_a = Long.parseLong(a);
        long l_b = Long.parseLong(b);
        if (l_a!=0&&l_b!=0){
            if ((a.charAt(0)=='0')||(b.charAt(0)=='0')){
                this.fuck = true;
            }
        }
        return Long.toString(l_a+l_b);
    }

    public void next(String num){
        list = new ArrayList<String[]> ();
        boolean flag = false;
        for (int i = 1; i <= num.length()/2; i++) {
            int j = 1;
            String a = num.substring(0,i);
            while (i+2*j<=num.length()){
                String b = num.substring(i,i+j);
                String addstrcat = addstrcat(a, b);
                if (i+j+addstrcat.length()<=num.length())
                {
                    String c = num.substring(i+j,i+j+addstrcat.length());
                    if (addstrcat.equals(c)){
                    //System.out.println(a+"+"+b+"="+c);
                    this.cur = i+j+addstrcat.length();
                    this.a = b;
                    this.b = c;
                    //System.out.println(cur);
                    flag = true;
                    break;
                }
                }
                j++;
            }
            if (flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        String a="abcd";
        System.out.println(a.substring(1,1));
    }
}
