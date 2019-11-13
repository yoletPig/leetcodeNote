package Math;

public class countNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int sum = 1;
        while (n>0){
            int temp = 9;
            for (int i = n-1;i>0;i--){
                temp *= (10-i);
            }
            sum+=temp;
            n--;
        }
        return sum;
    }

    public static void main(String[] args) {
        countNumbersWithUniqueDigits c = new countNumbersWithUniqueDigits();
        System.out.println(c.countNumbersWithUniqueDigits(9));
    }
}
