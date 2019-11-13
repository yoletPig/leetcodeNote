package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class fractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }

    public String fractionToDecimal1(int numerator, int denominator) {
        double k = (double) numerator / denominator;
        String s = String.valueOf(k);
        String[] split = s.split("\\.");
        if (split[1].equals("0")) {
            return split[0];
        }
        s = split[1];
        if (s.length()>3){
            char a = s.charAt(s.length()-1);
            char b = s.charAt(s.length()-2);
            char c = s.charAt(s.length()-3);
            if (c==b&&b-a==-1){
                s = s.substring(0,s.length()-1);
            }
        }
        String spre = "";
        int j = 0;
        while (j < s.length() / 2) {
            int i = 1;
            String sp = "";
            spre = s.substring(j);
            while (i < spre.length() / 2) {
                sp = spre.substring(0, i);
                split = spre.split(sp);
                if (split.length == 0) {
                    StringBuilder sb = new StringBuilder("");
                    split = String.valueOf(k).split("\\.");
                    if (j == 0) {
                        sb.append(split[0]).append(".(" + sp + ")");
                    } else {
                        sb.append(split[0] + ".").append(s.substring(0, j)).append("(" + sp + ")");
                    }
                    return sb.toString();
                }
                i++;
            }
            j++;
        }
        return String.valueOf(k);
    }

    public static void main(String[] args) {
        fractionToDecimal f = new fractionToDecimal();
        System.out.println(f.fractionToDecimal(1, 99));
    }
}
