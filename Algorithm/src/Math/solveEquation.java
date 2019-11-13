package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * 640 求解方程
 */
public class solveEquation {
    List<String> listAdd = new ArrayList();
    List<String> listS = new ArrayList();
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        f(split[0],true);
        f(split[1],false);
        System.out.println(listAdd);
        System.out.println(listS);
        int X = 0;
        int N = 0;
        for (String s : listAdd) {
            if (s.indexOf('x')!=-1){
                if (s.length()>1)
                {
                    X+=Integer.parseInt(s.substring(0,s.length()-1));
                }
                else {
                    X+=1;
                }
            }else {
                N+=Integer.parseInt(s);
            }
        }
        for (String s : listS) {
            if (s.indexOf('x')!=-1){
                if (s.length()>1)
                {
                    X-=Integer.parseInt(s.substring(0,s.length()-1));
                }
                else {
                    X-=1;
                }
            }else {
                N-=Integer.parseInt(s);
            }
        }
        System.out.println(X);
        System.out.println(N);
        if (X==0){
            if (N!=0){
                return "No solution";
            }else {
                return "Infinite solutions";
            }
        }
        return "x="+(-N/X);
    }
    public void f(String equation,boolean flag){
        int temp = 0;
        boolean is = flag;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i)=='+'){
                if (temp != i){
                    if (is){
                        listAdd.add(equation.substring(temp,i));
                    }else {
                        listS.add(equation.substring(temp,i));
                    }
                }
                temp = i+1;
                is = flag;
            }
            if (equation.charAt(i)=='-'){
                if (temp != i){
                    if (!is){
                        listS.add(equation.substring(temp,i));
                    }else {
                        listAdd.add(equation.substring(temp,i));
                    }
                }
                temp = i+1;
                is = !flag;
            }
        }
        if (is){
            listAdd.add(equation.substring(temp));
        }else {
            listS.add(equation.substring(temp));
        }
    }

    public static void main(String[] args) {
        String s = "3x=33+22+11";
        solveEquation se = new solveEquation();
        //se.f("-x+1-10x+9x+55");
        System.out.println(se.solveEquation(s));
    }
}
