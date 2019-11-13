package Hash;
import	java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class reorganizeString {
    public String reorganizeString(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (map.containsKey(c)) {
                int t = map.get(c);
                t++;
                map.put(c, t);
            } else {
                map.put(c, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (map.size()!=0){
            if (map.size()==1){
                if (sb.length()<1){
                    return "";
                }
                int t = 0;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                     t = entry.getValue();
                    Character c = entry.getKey();
                    if (c!=sb.charAt(0)){
                        if (t==0){
                        return sb.toString();
                    }
                        t--;
                        sb.insert(0,c);

                    }
                    if (c!=sb.charAt(sb.length() - 1)){
                        if (t==0){
                            return sb.toString();
                        }
                        t--;
                        sb.append(c);
                    }
                    for (int i = 0; i < sb.length()-1; i++) {
                        if (c!=sb.charAt(i)&&c!=sb.charAt(i+1)){
                            sb.insert(i+1,c);
                            t--;
                        }
                        if (t<=0){
                            return sb.toString();
                        }
                    }
                }
                return "";
            }
            else {
                ArrayList<Character> ch = new ArrayList<> ();
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    int t = entry.getValue();
                    Character c = entry.getKey();
                    sb.append(c);
                    t--;
                    if (t==0){
                        ch.add(c);
                    }
                    else {
                        map.put(c, t);
                    }
                }
                for (Character c : ch) {
                    map.remove(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        reorganizeString rg =new reorganizeString();
        String s ="nowpwibfd";
        System.out.println(rg.reorganizeString(s));
    }
}
