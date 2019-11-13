package Math;

import java.util.Arrays;

public class originalDigits {
    StringBuilder sb = new StringBuilder();
    int len = 0;
    public String originalDigits(String s) {
        String[] letter = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] ch = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'a'] += 1;
        }
        for (int i : ch) {
            if (i != 0) {
                len++;
            }
        }
        while (len > 0) {
            if (ch[25]!=0){
                ch = f(ch,25,letter [0],0);
                continue;
            }
            else if (ch[22]!=0){
                ch = f(ch,22,letter[2],2);
                continue;
            }
            else if (ch[20]!=0){
                ch = f(ch,20,letter[4],4);
                continue;
            }
            else if (ch[23]!=0){
                ch = f(ch,23,letter[6],6);
                continue;
            }
            else if (ch[6]!=0){
                ch = f(ch,6,letter[8],8);
                continue;
            }
            else if (ch[14]!=0){
                ch = f(ch,14,letter[1],1);
                continue;
            }
            else if (ch[7]!=0){
                ch = f(ch,7,letter[3],3);
                continue;
            }
            else if (ch[5]!=0){
                ch = f(ch,5,letter[5],5);
                continue;
            }
            else if (ch[18]!=0){
                ch = f(ch,18,letter[7],7);
                continue;
            }
            else if (ch[8]!=0){
                ch = f(ch,8,letter[9],9);
                continue;
            }
        }
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private int[] f(int[] ch, int k, String str, int num) {
        int temp;
        temp = ch[k];
        for (int i = 0; i < str.length(); i++) {
            ch[str.charAt(i) - 'a'] -= temp;
            if (ch[str.charAt(i) - 'a'] == 0) {
                len--;
            }
        }
        for (int idx = 0; idx < temp; idx++) {
            sb.append(num);
        }
        return ch;
    }

    public static void main(String[] args) {
        originalDigits od = new originalDigits();
        String b = "oneonetwothere";
        System.out.println(od.originalDigits(b));
    }
}
