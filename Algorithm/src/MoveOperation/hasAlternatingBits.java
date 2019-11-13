package MoveOperation;

/**
 * 693. 交替位二进制数
 * 难度
 * 简单
 *
 */
public class hasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int j = n^(n>>1);
        if ((j&(j+1))==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        hasAlternatingBits hb = new hasAlternatingBits();
        System.out.println(hb.hasAlternatingBits(8));
    }
}
