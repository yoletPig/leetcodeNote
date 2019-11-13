package String;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }

   /* public int firstUniqChar(String s) {
        for (char c = 'a';c<='z';c++){
            if (s.indexOf(c)!=-1&&(s.indexOf(c)==s.lastIndexOf(c))){
                return s.indexOf(c);
            }
        }
        return -1;
    }*/

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        String s = "leetcole";
        System.out.println(firstUniqChar.firstUniqChar(s));
    }
}
