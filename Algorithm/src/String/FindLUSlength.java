package String;
/*
七夕特别题目：521.最长特殊字符串
 */
public class FindLUSlength {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)){
            return -1;
        }
        return a.length()>b.length()?a.length():b.length();
    }
}
