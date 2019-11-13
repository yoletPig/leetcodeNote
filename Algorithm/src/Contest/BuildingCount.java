package Contest;

import java.util.Arrays;
import java.util.Random;
/**
 *小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高
 * 楼，共有n座高楼排成一行。
 * 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以
 * 他想知道他在每栋楼的位置处能看到多少栋楼呢?(当前面的楼的高度大
 * 于等于后面的楼时，后面的楼将被挡住)
 * 输入描述:
 * 输入第一行将包含一个数字，代表楼的栋数，接下来的一行将包含n个
 * 数字w(1<=i<=n)，代表每一栋楼的高度。
 * 1<=n<=100000;
 * 1<=w<=100000;
 * 输出描述:
 * 输出一行，包含空格分割的n个数v1分别代表小Q在第1栋楼时能看
 * 到的楼的数量，
 * 示例1
 * 6
 * 5 3 8 3 2 5
 *输出：
 * 3 3 5 4 4 4
 *
 */
public class BuildingCount {
    public int[] couB(int[] arr) {
        int[] count = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            int c = 0;
            int maxVal = 0;
            while (j < arr.length && arr[j] > maxVal) {
                maxVal = arr[j];
                c++;

                j++;
            }
            count[i] = c;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int j = i - 1;
            int c = 0;
            int maxVal = 0;
            while (j >= 0 && arr[j] > maxVal) {
                maxVal = arr[j];
                c++;
                j--;
            }
            count[i] += c;
        }
        for (int i = 0; i < count.length; i++) {
            count[i] += 1;
        }
        return count;
    }


    public static void main(String[] args) {
        BuildingCount b = new BuildingCount();
        int[] arr = new int[100000];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100000) + 1;
        }
        //int[] arr = {5,3,8,3,2,5};
        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        int[] couB = b.couB(arr);
        System.out.println(Arrays.toString(couB));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}
