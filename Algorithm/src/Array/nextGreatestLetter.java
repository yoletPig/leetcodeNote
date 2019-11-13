package Array;

/***
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 *
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 *
 * 示例:
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 *
 */

/*
思路分析：对于数组循环的取模值就行！记住了！
 */
public class nextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int mid = 0;
        while (left<=right){
            mid = (left + right)/2;
            if (letters[mid]>target){
                right = mid -1  ;
            }
            else{
                left = mid+1;
            }
        }
        return letters [left%letters.length];
    }

    public static void main(String[] args) {
        nextGreatestLetter ng = new nextGreatestLetter();
        char[] letters = {'c','f','j'};
        System.out.println(ng.nextGreatestLetter(letters,'c'));
    }
}
