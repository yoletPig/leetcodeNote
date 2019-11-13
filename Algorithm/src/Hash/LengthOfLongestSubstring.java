package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/*
3 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if(s.length()==1){
            return 1;}
        int h = 0;
        int r = 0;
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        Character c = null;
        while (r < s.length()) {
            c = s.charAt(r);
            if (set.contains(c)) {
                h++;
                r = h;
                set.removeAll(set);
            }
                set.add(c);
                r++;
        }
        return len;
    }

    //-----------------------------

        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }



    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        String s = "au";
        System.out.println(l.lengthOfLongestSubstring(s));
    }
}
