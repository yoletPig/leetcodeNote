package Contest.lanqiao;

import	java.util.Scanner;

public class word_Chain {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strs = new String[n];
        int[] arr = new int[n];
        int i = 0;
        while (i<n){
            strs[i] = in.next();
            i++;
        }
        StringBuilder sb = new StringBuilder(in.next());
        dfs(strs,sb,arr);
        System.out.println(max);
    }

    private static void dfs(String[]strs,StringBuilder sb,int[] arr) {
        if (sb.length() > max){
            max = sb.length();
        }
        char c = sb.charAt(sb.length() - 1);
        for (int i = 0; i < strs.length; i++) {
            if (arr[i]<2){
                int pos = strs[i].indexOf(c);
                if (pos!=-1){
                    String preStr = strs[i].substring(0, pos+1);
                    String tailStr = strs[i].substring(pos+1);
                    if (sb.length()-pos-1>=0&&pos!=strs[i].length()-1){
                        if (sb.toString().substring(sb.length() - pos-1).equals(preStr)){
                            StringBuilder sb_temp = new StringBuilder();
                            for (int k = 0; k < sb.length(); k++) {
                                sb_temp.append(sb.charAt(k));
                            }
                            sb_temp.append(tailStr);
                            int[] arr_temp = new int [arr.length];
                            for (int j = 0; j < arr.length; j++) {
                                arr_temp[j] = arr[j];
                            }
                            arr_temp[i]++;
                            dfs(strs,sb_temp,arr_temp);
                        }
                    }
                }
            }
        }
    }

}
