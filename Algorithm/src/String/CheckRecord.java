package String;

//551. 学生出勤记录
public class CheckRecord {
    public boolean checkRecord(String s) {
        int A_num=0;
        int L_num=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='L'){
                L_num++;
            }
            else if (s.charAt(i)=='A'){
                A_num++;
                L_num=0;
            }
            else {
                L_num=0;
            }
            if (L_num>2||A_num>1){
                return false;
            }
        }
        return true;
    }

    //执行0ms的范例；
    class Solution {
        public boolean checkRecord(String s) {
            return s.indexOf("A") == s.lastIndexOf("A") && s.indexOf("LLL") < 0;
        }
    }

    public static void main(String[] args) {
        CheckRecord record = new CheckRecord();
        System.out.println(record.checkRecord("PPALLLP"));
    }
}
