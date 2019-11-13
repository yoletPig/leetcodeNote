package greedy;

public class lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] changes = new int[2];
        for (int bill : bills) {
            if(bill==5){
                changes [0] += 1;
            }
            else if(bill==10){
                changes [0] -= 1;
                changes [1] += 1;
                if (changes [0] < 0){
                    return false;
                }
            }
            else{
                if (changes [0]>=1&&changes[1]>=1){
                    changes [0]-=1;
                    changes [1]-=1;
                }
                else {
                    changes [0] -= 3;
                }
                if (changes [0] < 0) {
                   return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        lemonadeChange lm = new lemonadeChange();
        int[] bills = {5,5,5,5,5,20};
        System.out.println(lm.lemonadeChange(bills));
    }
}
