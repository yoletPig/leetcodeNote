package String;

import java.util.*;


/**
 * 720
 */
public class longestWord {
    public String longestWord(String[] words) {
        ArrayList<String> AlongestWords = new ArrayList<String> ();
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            if (!set.contains(word)){
                set.add(word);
            }
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                 int i = o1.length() - o2.length();
                 if (i==0){
                     i = o2.charAt(0)-o1.charAt(0);
                 }
                 return i;
            }
        });
        int len = 0;
        for (int i = words.length - 1; i >= 0; i--) {
            int j = words[i].length()-1;
            while (j>0){
                if (set.contains(words [i].substring(0,j))){
                    j--;
                }
                else {
                    break;
                }
            }
            if (j==0)
            {
                len = Math.max(len,words [i].length());
                if (words [i].length()<len){
                    break;
                }
                else {
                    AlongestWords.add(words [i]);
                }
            }
        }
        Collections.sort(AlongestWords);
        return AlongestWords.get(0);
    }

    public static void main(String[] args) {
        longestWord lw = new longestWord();
        String[] words = {"vsw","vs","zwu","vsx","nc","o","vswus","orv","imf","i","v","zw","vs"};
        System.out.println(lw.longestWord(words));
    }
}
