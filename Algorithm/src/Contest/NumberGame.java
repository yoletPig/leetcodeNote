package Contest;

public class NumberGame {
    public int NumberGame(int n,int k,int T){
        int ans = 0;//冻冻所有数字的总和
        int count = 0;//冻冻说出数字的次数
        int increase = 1;//自增差值
        int curNum = 1;//当前数字
        int i = 0;//记录次数，i%n == 0 时，代表是冻冻的
        while (count<T){
            if (i%n==0){
                ans+=curNum;
                count++;
            }
            curNum+=increase;
            if (curNum>=k){
                curNum-=k;
            }
            i++;
            increase++;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberGame ng = new NumberGame();
        System.out.println(ng.NumberGame(3,13,3));
    }
}
