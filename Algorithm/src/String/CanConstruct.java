package String;

public class CanConstruct {
    public boolean canConstruct(String ransomNote,String magazine){

        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i)-'a']--;
        }
        for (int i : arr) {
            if (i<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanConstruct c = new CanConstruct();
        System.out.println(c.canConstruct("aa","ab"));
    }
}
