package Contest;

import java.util.*;

/**
 * 超时
 */
public class canMakePaliQueries {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        ArrayList<Boolean> result = new ArrayList<Boolean>();
        for (int i = 0; i < queries.length; i++) {
            boolean b = isPalindrome(s,queries [i][0],queries [i][1],queries [i][2]);
            result.add(b);
        }
        return result;
    }

    public boolean isPalindrome(String s, int left, int right, int k) {
        if (k>(right-left)/2){
            return true;
        }
        s = s.substring(left, right+1);
        if (s.length()==1){
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        //用map存放每个字符的个数；
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                count++;
                map.put(c, count);
            }
            else {
                map.put(c, 1);
            }
        }
        //遍历map，获取字符数是奇数的字符个数；
        int count = 0;
        for (Character character : map.keySet()) {
            if (map.get(character) % 2 !=0){
                count++;
            }
        }
        if (s.length()%2==0&&count <= 2*k){
            return true;
        }
        if (s.length()%2!=0&&(count-1) <= 2*k){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        canMakePaliQueries cm = new canMakePaliQueries();
        String s = "abcda";
        int[][] queries = {{0,4,1}};
        List<Boolean> li = cm.canMakePaliQueries(s, queries);
        System.out.println(li);
    }
}
