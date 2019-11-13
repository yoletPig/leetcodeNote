package Array;

import java.util.ArrayList;
import java.util.List;

public class numSubarraysWithSum {
    public int numSubarraysWithSum1(int[] A, int S) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int j = i;
            int sum = 0;
            while (sum <= S && j < A.length) {
                sum += A[j];
                j++;
                if (sum == S) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numSubarraysWithSum(int[] A, int S) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            A[i] = sum;
        }
        int count = 0;
        for (int i = A.length-1; i >= 0; i--) {
           if (A[i]>=S){
               if (A[i]==S){
                   count++;
               }
                int j = 0;
                while (j<i){
                    if (A[i]-A[j]<S){
                        break;
                    }
                    if (A[i]-A[j]==S){
                        count++;
                    }
                    j++;
                }
            }
            else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        numSubarraysWithSum nm = new numSubarraysWithSum();
        int[]A={0,0,0,0,0};
        System.out.println(nm.numSubarraysWithSum(A,0));
    }
}
