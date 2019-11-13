package String;

import java.util.ArrayList;
import java.util.List;

public class commonChars {
    public List<String> commonChars(String[] A) {
        int[] stand = new int[26];
        for(int i = 0;i<A[0].length();i++){
            char c = A[0].charAt(i);
            stand[c-'a'] += 1;
        }
        for(int i = 1;i<A.length;i++){
            int[] temp = new int[26];
            for(int j = 0;j<A[i].length();j++){
                char c = A[i].charAt(j);
                temp[c-'a'] += 1;
            }
            for(int k = 0;k<26;k++){
                stand[k] = Math.min(stand[k],temp[k]);
            }
        }
        List<String> list = new ArrayList<>();
        for(int i = 0;i<26;i++){
            int j = 0;
            while (j<stand[i]){
                list.add(String.valueOf((char) ('a'+i)));
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        commonChars nq = new commonChars();
        String[] A = {"bella","label","roller"};
        List<String> strings = nq.commonChars(A);
        System.out.println(strings);
    }
}
