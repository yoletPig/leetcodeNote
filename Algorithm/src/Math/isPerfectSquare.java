package Math;

public class isPerfectSquare {
    public boolean isPerfectSquare1(int num) {
        int i = 1;
        int sum = 0;
        while (sum < num){
            sum+=i;
            i+=2;
        }
        if (sum==num){
            return true;
        }
        return false;
    }
//第一种超时，第二种超过80%人？？？
    public boolean isPerfectSquare2(int num) {
        int i = 1;
        while (num>0){
            num-=i;
            i+=2;
        }
        return num==0;
    }
}
