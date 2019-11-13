package String;

import java.util.Arrays;
import java.util.Comparator;

public class largestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String [nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = 0;
                int j = 0;
                int k = 0;
               /* String o3 = o1;
                if (o1.length()>o2.length()){
                    o1 = o2;
                    o2 = o3;
                }*/
               int len = o2.length();
               boolean flag = false;
               k = j;
                if (o1.length()>o2.length()){
                    len = o1.length();
                    flag = true;
                    k=i;
                }
                while (k<len&&o1.charAt(i)==o2.charAt(j)){
                    if (flag){
                        if (j == o2.length()-1){
                            j = 0;
                            i++;
                            k++;
                            continue;
                        }
                    }
                    else {
                        if (i == o1.length()-1){
                            i = 0;
                            j++;
                            k++;
                            continue;
                        }
                    }
                    i++;
                    j++;
                    k++;
                }
                if (k>=len){
                    if (flag){
                        return o2.charAt(j)-o1.charAt(0);
                    }else {
                        return o2.charAt(0)-o1.charAt(i);
                    }
                }
                return o2.charAt(j)-o1.charAt(i);
            }
        });
        //System.out.println(Arrays.toString(strs));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        if (sb.toString().charAt(0)=='0'){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        largestNumber ln = new largestNumber();
        int[] nums = {0,0};
        System.out.println(ln.largestNumber(nums));
    }
}
