package Array;
import java.util.Arrays;

public class longestWPI {
    public int longestWPI(int[] hours) {
        int max = 0;
        int[] pre = new int[hours.length+1];
        pre[0] = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i]>8){
                pre[i+1] = pre [i]+1;
            }
            else {
                pre[i+1] = pre [i]-1;
            }
        }
        System.out.println(Arrays.toString(pre));

        for (int i = pre.length - 1; i >= 0; i--) {
            int j = 0;
            while (j<i){
                if (pre [i]-pre [j]>0){
                    if (i-j>max){
                        max = i-j;
                    }
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        longestWPI lw = new longestWPI();
        int [] hours  = {9,9,6,0,6,6,9};
        System.out.println(lw.longestWPI(hours));
    }
}
