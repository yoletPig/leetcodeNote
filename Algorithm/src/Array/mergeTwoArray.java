package Array;

public class mergeTwoArray {
    public static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        int j;
        for (int i = 0; i < n; i++) {
            int temp = nums2[i];
            j = m - 1 + i;
            while (j >= 0 && nums2[i] < nums1[j]) {
                nums1[j + 1] = nums1[j];
                j--;
            }
            nums1[j + 1] = temp;
        }
        return nums1;
    }

    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 || n == 0) {
            if (m == 0) {
                for (int k = n - 1; k >= 0; k--) {
                    nums1[k] = nums2[k];
                }
            }
        } else {
            for (int i = m - 1, j = n - 1; i >= 0 && j >= 0; ) {
                if (nums1[i] <= nums2[j]) {
                    nums1[i + j + 1] = nums2[j];
                    j--;
                } else {
                    nums1[i + j + 1] = nums1[i];
                    i--;
                }

                if (i < 0 && j >= 0) {
                    for (int k = j; k >= 0; k--) {
                        nums1[k] = nums2[k];
                    }
                }
            }
        }
        return nums1;
    }
}
