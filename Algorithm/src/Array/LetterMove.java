package Array;

/**
 * 字母移位
 */
public class LetterMove {
    public String LetterMove(String S, int[] shifts){
        int n = 0;
        char[] chars = S.toCharArray();
        for (int i = shifts.length - 1; i >= 0; i--) {
            n+=shifts [i];
            n%=26;
            chars [i] = (char)('a'+(chars [i]-'a'+n)%26);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        LetterMove lm = new LetterMove();
        String S = "bad";
        int[] shifts = {10,20,30};
        System.out.println(lm.LetterMove(S,shifts));
    }
}
