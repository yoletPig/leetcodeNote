package Math;

public class CheckPerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        if (sum == num - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckPerfectNumber c = new CheckPerfectNumber();
        System.out.println(c.checkPerfectNumber(0));
    }
}
