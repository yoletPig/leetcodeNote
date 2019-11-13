package Hash;

import java.util.HashMap;
/*
242 isAnagram
 */

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())
        {
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)){
                int count = map.get(c);
                count++;
                map.put(c,count);
            }
            else {
                map.put(c,0);
            }
        }
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)){
                if (map.get(c)==0){
                    map.remove(c);
                }
                else {
                    int count = map.get(c);
                    count--;
                    map.put(c, count);
                }
            }
            else {
                return false;
            }
        }
        if (map.size()==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram("aba","aab"));
    }
}
