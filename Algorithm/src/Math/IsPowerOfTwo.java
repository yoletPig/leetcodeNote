package Math;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        double v = Math.log10(n) / Math.log10(4);
        if ((v*100)%100==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        System.out.println(isPowerOfTwo.isPowerOfTwo(256));
    }
}
