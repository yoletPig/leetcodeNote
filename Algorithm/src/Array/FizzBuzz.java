package Array;
import	java.util.ArrayList;

import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<> ();
        for (int i = 1; i <= n; i++) {
            if (i % 3 ==0 && i % 5 == 0){
                list.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0){
                list.add("Fizz");
                continue;
            }
            if (i % 5 == 0){
                list.add("Buzz");
                continue;
            }
            else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FizzBuzz a = new FizzBuzz();
        System.out.println(a.fizzBuzz(3));
    }
}
