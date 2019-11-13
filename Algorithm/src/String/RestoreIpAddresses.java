package String;
import	java.util.ArrayList;


import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        if (s.length()>12){
            return new ArrayList<String> ();
        }
        ArrayList<String> result = new ArrayList<String> ();
        String part1;
        String part2;
        String part3;
        String part4;
        int j = 1;
        int i = 1;
        int k = 1;
        /*part1 = s.substring(0,1);
        part2 = s.substring(1,2);
        part3 = s.substring(2,3);
        part4 = s.substring(3);
        System.out.println(part1 +" "+part2 +" "+ part3+" "+part4);*/
        for (; i < 4; i++) {
            j = 1;
            for (; j < 4; j++) {
                k = 1;
                for (; k < 4&&i+j+k<=s.length(); k++) {
                    part1 = s.substring(0,i);
                    part2 = s.substring(i,i+j);
                    part3 = s.substring(i+j,i+j+k);
                    part4 = s.substring(i+j+k);
                    if (part4.length()!=0){
                        if (valid(part4)&&valid(part3)&&valid(part2)&&valid(part1)){
                            result.add(part1 + "."+part2 + "."+part3+"."+part4);
                        }
                    }
                }
            }
        }
        return result;
    }
    public boolean valid (String s){
        Integer i = Integer.valueOf(s);
        String str = String.valueOf(i);
        if (i>=0&&i<=255&&str.length()==s.length()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RestoreIpAddresses s = new RestoreIpAddresses();
        List<String> list;
        list = s.restoreIpAddresses("0279245587303");
        System.out.println(list);
    }
}
