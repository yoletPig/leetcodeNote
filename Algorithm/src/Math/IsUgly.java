package Math;

public class IsUgly {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        for (int i = 2; i < 6; i++) {
            if (i == 4) {
                continue;
            }
            while (num % i == 0) {
                num /= i;
                if (num == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isUgly99(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        IsUgly isUgly = new IsUgly();
        System.out.println(isUgly.isUgly(20));
    }
}
