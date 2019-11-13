package String;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;

public class partitionLabels {
    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Character> set = new HashSet<>();
        int pos = 0;
        int i = 0;
        while (i < S.length()) {
            char c = S.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                int j = S.lastIndexOf(c);
                if (j>pos){
                    pos = j;
                }
            }
            if (i == pos ){
                list.add(pos+1);
                S = S.substring(pos+1);
                pos = 0;
                i = 0;
                continue;
            }
            i++;
        }
        return list;
    }

    public static void main(String[] args) {
        partitionLabels pl = new partitionLabels();
        String S = "caedbdedda";
        System.out.println(pl.partitionLabels(S));
    }
}
