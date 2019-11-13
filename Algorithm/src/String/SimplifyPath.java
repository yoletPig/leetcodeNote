package String;

import java.util.ArrayList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<> ();
        String[] split = path.split("/");
        for (String s1 : split) {
            if (s1.length()==0||s1.equals(".")){
                continue;
            }
            if (s1.equals("..")&&list.size()!=0){
                list.remove(list.size()-1);
                continue;
            }
            else if (!s1.equals("..")){
                list.add(s1);
            }
        }
        String string = "/";
        if (list.size()!=0){
            for (String s1 : list) {
                sb.append("/");
                sb.append(s1);
            }
            string = sb.toString();
        }
        return string;
    }

    public static void main(String[] args) {
      SimplifyPath sp = new SimplifyPath();
      String path = "/../";
      System.out.println(sp.simplifyPath(path));
    }
}
