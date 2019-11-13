package String;

import java.util.Arrays;

/*
345 编写一个函数，以字符串作为输入，反转该字符串中的元音字母.
 */
public class ReverseVowels {
    public static String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char temp;
        char[] chars;
        StringBuilder ss = new StringBuilder(s);
        chars = s.toCharArray();
        while (i < j) {
            while (i<j&&chars[i] != 'a' && chars[i] != 'e' && chars[i] != 'i' && chars[i] != 'o' && chars[i] != 'u' && chars[i] != 'A' && chars[i] != 'E' && chars[i] != 'I' && chars[i] != 'O' && chars[i] != 'U') {
                i++;
            }
            while (j>i&&chars[j] != 'a' && chars[j] != 'e' && chars[j] != 'i' && chars[j] != 'o' && chars[j] != 'u' && chars[j] != 'A' && chars[j] != 'E' && chars[j] != 'I' && chars[j] != 'O' && chars[j] != 'U') {
                j--;
            }
            if (i<j&&(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u' || chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U')
                    &&(chars[j] == 'a' || chars[j] == 'e' || chars[j] == 'i' || chars[j] == 'o' || chars[j] == 'u' || chars[j] == 'A' || chars[j] == 'E' || chars[j] == 'I' || chars[j] == 'O' || chars[j] == 'U')
                    ){
            temp = s.charAt(i);
            ss.setCharAt(i,s.charAt(j));
            ss.setCharAt(j,temp);
            i++;
            j--;
        }
        }
        return ss.toString();
    }
/*
一开始用字符数组存，发现Arrays.toString方法返回的是带【】和，的
所以不得不用循坏来重组字符串，但这样时间复杂度巨高；
又开始想，能不能直接对字符串进行交换，就不用数组去存，因为一个单一的
字符串是常量来的，我们并不能改变它，但在javase中，StringBuffer跟StringBuilder
恰恰相反，我们可以用.append方法来连接，也可以用.setCharAt()方法来进行交换。
总结，StringBuffer跟StringBuilder是可变字符串。
 */
    public static void main(String[] args) {
        String s = "Egad! Loretta has Adams as mad as a hatter. Old age!";
        s = reverseVowels(s);
        System.out.println(s);
    }
}
