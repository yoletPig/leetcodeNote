package Hash;
import java.util.*;

public class advantageCount {
    ArrayList<Integer> List = new ArrayList<>();
    HashMap<Integer, ArrayList < Integer>> map = new HashMap<Integer, ArrayList<Integer>> ();
    public int[] advantageCount(int[] A, int[] B) {
        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i])){
                map.get(B[i]).add(i);
            }
            else {
                ArrayList<Integer> list = new ArrayList<Integer> ();
                list.add(i);
                map.put(B[i],list);
            }
            List.add(B[i]);
        }
        Collections.sort(List);
        //System.out.println(List);
        int[] res = new int[A.length];
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 0; i--) {
            res[bs(A[i])] = A[i];
        }
        return res;
    }

    private int bs(int a){
        int left = 0;
        int right = List.size()-1;
        int mid = 0;
        while (left<=right){
            mid = (left+right)/2;
            if (List.get(mid)<a){
                left = mid+1;
                if (mid!=List.size()-1&&List.get(mid+1)>=a){
                    break;
                }
            }
            else {
                right = mid-1;
            }
        }
        ArrayList<Integer> list = map.get(List.get(mid));
        int res = list.get(0);
        if (list.size()==1){
            map.remove(List.get(mid));
    }
        else {
            list.remove(0);
        }
        List.remove(List.get(mid));
        return res;
    }

    public static void main(String[] args) {
        advantageCount ac = new advantageCount();
        int[] A = {};
        int[] B = {};

        System.out.println(Arrays.toString(ac.advantageCount(A,B)));
    }
}

class Solution1 {
    public int[] advantageCount(int[] A, int[] B) {
        Map<Integer, Queue<Integer>> pos = new HashMap<>();
        for(int i=0;i<B.length;i++) {
            if(pos.containsKey(B[i])) {
                pos.get(B[i]).offer(i);
            } else {
                Queue q = new ArrayDeque<Integer>();
                q.offer(i);
                pos.put(B[i], q);
            }
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int[] ans = new int[A.length];
        int j = B.length - 1;
        int k = 0;
        for(int i=0;i<A.length;i++) {
            if(A[i] > B[k]) {
                ans[pos.get(B[k++]).poll()] = A[i];
                //正常情况直接输入
            } else {
                //连比当前B中最小那个都小，直接推掉B中最大
                ans[pos.get(B[j--]).poll()] = A[i];
            }
        }
        return ans;
    }
}

class Solution2 {

    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        int[] idx = new int[n];
        Arrays.sort(A);
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        quickSort(B, idx, 0, n - 1);
        int maxIdx = n - 1;
        int index = n - 1;
        int minIdx = 0;
        while (index >= 0) {
            if (B[index] < A[maxIdx]) {
                res[idx[index]] = A[maxIdx];
                maxIdx--;
                index--;
            }else {
                res[idx[index]] = A[minIdx];
                minIdx++;
                index--;
            }
        }
        return res;
    }

    private void quickSort(int[] B, int[] idx, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(B, idx, lo, hi);
        quickSort(B, idx, lo, j - 1);
        quickSort(B, idx, j + 1, hi);
    }

    private int partition(int[] B, int[] idx, int lo, int hi) {
        int l = lo;
        int r = hi + 1;
        int com = B[lo];
        while (true) {
            while (B[++l] < com) {
                if (l == hi) {
                    break;
                }
            }

            while (B[--r] > com) {
                if (r == lo) {
                    break;
                }
            }
            if (l >= r) {
                break;
            }
            swap(B, l, r);
            swap(idx, l, r);
        }
        swap(B, lo, r);
        swap(idx, lo, r);
        return r;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

















