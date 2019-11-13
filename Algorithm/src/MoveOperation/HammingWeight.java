package MoveOperation;
/*
位运算
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int count=0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
