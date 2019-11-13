package Dynamic;


import java.util.HashMap;
import java.util.Map;

public class lenLongestFibSubseq {
    /**
     *思路：动态规划，思路一致，两层循环，动态推算，向前找最长的两个子项，难点在于将两个子项合拼成一个（i,j）=i*N+j,这个思路是真的棒。
     * @param A
     * @return
     */
    public int lenLongestFibSubseq_64ms(int[] A) {
        int N = A.length;
        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i) {
            index.put(A[i], i);
        }

        Map<Integer, Integer> longest = new HashMap();
        int ans = 0;

        for (int k = 0; k < N; ++k) {
            for (int j = (k / 2) - 1; j < k && j >= 0; ++j) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    // Encoding tuple (i, j) as integer (i * N + j)
                    int cand = longest.getOrDefault(i * N + j, 2) + 1;
                    longest.put(j * N + k, cand);
                    ans = Math.max(ans, cand);
                    System.out.println("i*N+j = "+(i*N+j)+" j*N+k = "+(j*N+k));
                }
            }
        }

        return ans >= 3 ? ans : 0;
    }

    /**
     * 暴力寻找每一条链，用迭代！提醒一波，关于斐波那契数列的用迭代会有意想不到的结果（手动狗头XD）；
     * @param A
     * @return
     */
    public int lenLongestFibSubseq_6ms(int[] A) {
        int len = A.length, ans = 0;
        for (int i = 0; i < len - 2; i++) {
            int pos = i + 2;
            for (int j = i + 1; j < len - 1; j++) {
                int sum = A[i] + A[j];
                while (pos < len && A[pos] < sum) {
                    pos++;
                }
                if (pos == len) {
                    return ans;
                }
                if (A[pos] != sum) {
                    continue;
                }
                int b = sum, c = sum + A[j], curLen = 3, k = pos;
                while (true) {
                    while (k < len && A[k] < c){
                        k++;
                    }
                    if (k == len) {
                        break;
                    }
                    if (A[k] != c) {
                        break;
                    }
                    curLen++;
                    c = c + b;
                    b = c - b;
                }
                ans = Math.max(ans, curLen);
            }
            if (pos == len) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        lenLongestFibSubseq lq = new lenLongestFibSubseq();
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = lq.lenLongestFibSubseq_64ms(A);
        System.out.println(i);
    }
}
