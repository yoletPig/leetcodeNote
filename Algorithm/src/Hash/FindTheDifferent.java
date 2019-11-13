package Hash;

/*
389. 找不同
对于相同的都可以用异或 或者 hash表
 */

public class FindTheDifferent {
    public static char findTheDifference1(String s,String t){
        byte[] num = new byte[26];
        //字节数组初始化是多少？
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i)-97]--;
        }
        for (int i = 0; i < t.length(); i++) {
            num[t.charAt(i)-97]++;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i]==1){
                return (char)(i+97);
            }
        }
        return 'a';
    }

    public static char findTheDifference(String s,String t){
        int res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return (char)res;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd","abcdd"));
    }
}
