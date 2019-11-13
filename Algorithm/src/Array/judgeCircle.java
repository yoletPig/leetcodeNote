package Array;

public class judgeCircle {
    public boolean judgeCircle(String moves) {
        int[] ch = new int[4];
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                ch[0] += 1;
            } else if (c == 'D') {
                ch[1] += 1;
            } else if (c == 'L') {
                ch[2] += 1;
            } else {
                ch[3] += 1;
            }
        }
        return ch [0]==ch [1]&&ch [2]==ch [3];
    }
}
