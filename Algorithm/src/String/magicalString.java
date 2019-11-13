package String;

public class magicalString {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int count = 1;
        int i = 2;
        while (sb.length()<n){
            char c = sb.charAt(i);
            char last = sb.charAt(sb.length() -1);
            if (c=='2'){
                if (last=='1'){
                    sb.append("22");
                }
                else {
                    sb.append("11");
                    count+=2;
                }
            }
            else {
                if (last=='1'){
                    sb.append("2");
                }
                else {
                    sb.append("1");
                    count+=1;
                }
            }
            i++;
        }
        //System.out.println(sb.toString());
        if (sb.length()>n){
            if (sb.charAt(sb.length() - 1)=='1'){
                return count-1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        magicalString ms = new magicalString();
        System.out.println(ms.magicalString(4));
    }
}
