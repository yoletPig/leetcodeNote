package DataStructure_Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortTest {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
        arr = Quick_sort.quickSort(arr,0,999);
        for (int i = 0; i < arr.length; i++) {
            if(i%20 == 0){
                System.out.println(arr[i]);
            }
            System.out.print(arr[i]+" ");
        }
    }
}
