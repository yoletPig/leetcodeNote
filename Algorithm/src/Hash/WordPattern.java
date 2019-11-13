package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/*
290 单词规律
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if (pattern.length()!=s.length){
            return false;
        }
        HashMap<Character,String> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            Character c = pattern.charAt(i);
            if (map.containsKey(c)){
                if (!s[i].equals(map.get(c))){
                    return false;
                }
            }
            else {
                map.put(c,s[i]);
            }
        }
        HashSet<String> set = new HashSet<>();
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            if (set.contains(entry.getValue())){
                return false;
            }
            else {
                set.add(entry.getValue());
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "dog dog dog dog";
        String pattern = "abba";
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern(pattern,string));
    }
}
