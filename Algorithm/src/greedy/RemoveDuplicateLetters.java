package greedy;


import java.util.*;

/**
 * 316 去除重复字母
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 * <p>
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 * <p>
 * 栈解法：题意大概就是 按顺序来（左->右） 将比较小的字符排进去 如果这个字符没重复 就不能删除 。
 */
public class RemoveDuplicateLetters {

    public String removeduplicateletters1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.contains(c)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        char chars[] = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);
    }

    //---------------------------------------
    int len = 0;
    HashSet<String> set = new HashSet<>();

    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return "";
        }
        HashSet<Character> stack = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!stack.contains(c)) {
                stack.add(c);
            }
        }
        len = stack.size();
        String subs = "";
        subs += s.charAt(0);
        f(s, 1, subs);
        ArrayList<String> list = new ArrayList<>();
        for (String s1 : set) {
            list.add(s1);
        }
        Collections.sort(list);
        return list.get(0);
    }

    public void f(String s, int i, String subs) {
        if (!set.contains(subs) && subs.length() == len) {
            set.add(subs);
        }
        if (i == s.length()) {
            return;
        }
        if (subs.indexOf(s.charAt(i)) == -1) {
            subs += s.charAt(i);
            f(s, i + 1, subs);
        } else {
            String temp = subs;
            char[] chars = subs.toCharArray();
            for (int j = subs.indexOf(s.charAt(i)); j < chars.length - 1; j++) {
                chars[j] = chars[j + 1];
            }
            chars[chars.length - 1] = s.charAt(i);
            subs = String.valueOf(chars);
            f(s, i + 1, subs);
            subs = temp;
            f(s, i + 1, subs);
        }
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters rd = new RemoveDuplicateLetters();
        String s = "bcabc";
        System.out.println(rd.removeDuplicateLetters(s));
    }
}
