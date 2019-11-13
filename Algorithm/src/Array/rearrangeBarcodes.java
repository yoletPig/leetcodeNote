package Array;

import java.util.*;

/**
 * 1054. 距离相等的条形码
 * 难度
 * 中等
 *
 * 16
 *
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 通过次数
 * 1,323
 * 提交次数
 * 4,694
 * 题目描述
 * 评论 (26)
 * 题解(15)New
 * 提交记录
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 *
 * 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 *
 * 输入：[1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 */

public class rearrangeBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes.length <= 1) {
            return barcodes;
        }
        int[] res = new int[barcodes.length];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            if (map.containsKey(barcodes[i])) {
                int temp = map.get(barcodes[i]);
                map.put(barcodes[i], ++temp);
            } else {
                map.put(barcodes[i], 1);
            }
        }
        int i = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        while (list.size() > 1) {
            int k = 0;
            for (Map.Entry<Integer, Integer> entry : list) {
                res[i] = entry.getKey();
                int temp = entry.getValue();
                entry.setValue(--temp);
                i++;
                k++;
                if (entry.getValue() == 0) {
                    list.remove(entry);
                    break;
                }
                if (k % 2 == 0) {
                    break;
                }
            }
        }
        int len = list.iterator().next().getValue();
        int barcode = list.iterator().next().getKey();
        for (int j = res.length - len - 1; j >= 0 && len > 0; j--) {
            if (j==0){
                if (barcode!=res[res.length -2]){
                    res[res.length -1] = barcode;
                }
                len--;
                break;
            }
            if (barcode != res[j] && barcode != res[j - 1]) {
                for (int k = res.length - len - 1; k >= j; k--) {
                    res[k + 1] = res[k];
                }
                res[j] = barcode;
                len--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2};
        rearrangeBarcodes rrb = new rearrangeBarcodes();
        System.out.println(Arrays.toString(rrb.rearrangeBarcodes(nums)));
    }
}

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        /* 存在特殊情况结果类似 2, 1, 2, 1, 2
         * 因此优先使用出现次数最多的元素填充奇数位
         */
        /* 统计每个数据的出现次数 */
        int len = barcodes.length;
        int[] count = new int[10001];
        for (int i = 0; i < len; i++) {
            count[barcodes[i]]++;
        }
        /* 得到出现次数最多的数字 */
        int maxCnt = 0;
        int maxNum = 0;
        for (int i = 1; i < 10001; i++) {
            if (count[i] > maxCnt) {
                maxCnt = count[i];
                maxNum = i;
            }
        }
        /* 先填充奇数位 */
        int[] result = new int[len];
        int pos = 0;    // result 填充位置
        int idx = 0;    // count 使用位置
        /* 先使用出现次数最多的数字填充奇数位, 最多恰好填满 */
        while (pos < len) {
            if (count[maxNum] <= 0) {
                break;  // 填充完毕
            } else {
                count[maxNum]--;
                result[pos] = maxNum;
                pos += 2;
            }
        }
        /* 尝试继续填充奇数位 */
        while (pos < len) {
            if (count[idx] <= 0) {
                idx++;
                continue;
            } else {
                count[idx]--;
                result[pos] = idx;
                pos += 2;
            }
        }
        /* 继续填充偶数位 */
        pos = 1;
        while (pos < len) {
            if (count[idx] <= 0) {
                idx++;
                continue;
            } else {
                count[idx]--;
                result[pos] = idx;
                pos += 2;
            }
        }
        return result;
    }
    //简单粗暴，我没想到！
}
