package MoveOperation;
/*
258 各位相加
 */
public class AddDigits {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }

    public static void main(String[] args) {
        AddDigits d = new AddDigits();
        System.out.println(d.addDigits(38));
    }
}
