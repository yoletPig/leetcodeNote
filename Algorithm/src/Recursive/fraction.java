package Recursive;

import java.util.Arrays;

public class fraction {
    public int[] fraction(int[] cont) {
        if (cont.length <= 1){
            return new int [] {cont [0],1};
        }
        return f(cont,cont.length-2,1,cont[cont.length -1]);
    }

    private int[] f(int[] cont,int k , int x ,int y){
        int[] ans = new int[2];
        if (k==0){
            ans [0] = cont[k]*y+x;
            ans [1] = y;
            return ans;
        }
        return f(cont,--k,y,cont[k+1]*y+x);
    }

    public static void main(String[] args) {
        fraction fraction = new fraction();
        int[] cont = {3,2,0,2};
        System.out.println(Arrays.toString(fraction.fraction(cont)));
    }
}
