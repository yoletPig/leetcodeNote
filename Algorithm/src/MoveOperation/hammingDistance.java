package MoveOperation;

public class hammingDistance {
    public int hammingDistance(int x, int y) {
        //清除相同元素；
        x ^= y;
        //获取 1 的个数；
        int count = 0;
        while (x!=0){
            x&=(x-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        hammingDistance hm = new hammingDistance();
        System.out.println(hm.hammingDistance(1,4));
    }
}
