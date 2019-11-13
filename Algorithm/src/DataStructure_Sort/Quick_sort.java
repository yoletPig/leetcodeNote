package DataStructure_Sort;

public class Quick_sort {
    public static int[] quickSort(int[] arr,int left,int right) {
        int i = left+1,j = right;
        if(left>right) return arr;
        if(right-left<=1) {
            if(arr[left]>=arr[right]) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            return arr;
        }
        int key = arr[left];
        while(i<j) {
            while(i<right&&arr[i]<=key) {
                i++;
            }
            while(j>left&&arr[j]>=key) {
                j--;
            }
            if(i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[left];
        arr[left] = arr[j];
        arr[j] = temp;
        quickSort(arr,left,j-1);
        quickSort(arr,j+1,right);
        return arr;
    }
}
