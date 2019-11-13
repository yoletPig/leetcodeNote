package Math;

import java.util.Arrays;

public class countDigitOne {
    int ans = 0;
    public int countDigitOne(int n) {
        for (int i = 1; i <= n; i++) {
            f(i);
        }
        return ans;
    }

    private void f(int num){
        while (num!=0){
            if (num%10==1){
                ans++;
            }
            num /= 10;
        }
    }

    public static void main(String[] args) {
        countDigitOne co = new countDigitOne();
        System.out.println(co.countDigitOne(20));
    }
}
