package String;

public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int i=0;
        int j=0;
        int k = 0;
        for (k = 0; k < s3.length(); k++) {
            if (k-j<s1.length()&&(s3.charAt(k)==s1.charAt(k-j))){
                i++;
                continue;
            }
            if (k-i<s2.length()&&(s3.charAt(k)==s2.charAt(k-i))){
                j++;
                continue;
            }
        }
        if (i+j<k){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsInterleave is = new IsInterleave();
        String s1 = "bcc", s2 = "bbca", s3 = "bbcbcac";
       // String s1 = "aac", s2 = "dbb", s3 = "aabdbc";
        System.out.println(is.isInterleave(s1, s2, s3));
    }
}
