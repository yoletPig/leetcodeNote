package Contest.lanqiao;
import java.math.BigInteger;
import java.util.Scanner;

public class Stairs_BigInteger {
    void fun() {
        Scanner in = new Scanner(System.in);
        staris(in.nextInt());
    }

    void staris(int n){
        BigInteger res = new BigInteger("0");
        if (n==1){
            res = BigInteger.valueOf(1);
        }
        if (n==2){
            res = BigInteger.valueOf(2);;
        }
        BigInteger x1 = new BigInteger("1");
        BigInteger x2 = new BigInteger("2");
        for (int i = 2; i < n; i++) {
            res = x1.add(x2);
            x1 = x2;
            x2 = res;
        }
        System.out.println(res.toString());
    }

    public static void main(String[] args) {
        Stairs_BigInteger m = new Stairs_BigInteger();
        m.fun();
    }
}