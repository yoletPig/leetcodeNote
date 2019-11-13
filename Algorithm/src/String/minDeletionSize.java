package String;

public class minDeletionSize {
    public int minDeletionSize1(String[] A) {
        if (A.length <=1){
            return 0;
        }
        int j = 0;
        int len = 0;
        boolean[] B = new boolean [A[0].length()];
        while (j<A[0].length()){
            boolean flag = true;
            for (int i = 0; i < A.length-1; i++) {
                if (A [i].charAt(j)>A[i+1].charAt(j)){
                    if (j!=0){
                        //去左边找，如果是true
                        int k = j-1;
                        boolean isequal = true;
                        while (k>=0){
                            if (B[k]){
                                if (A[i].charAt(k)!=A[i+1].charAt(k)){
                                    isequal = false;
                                }
                                break;
                            }
                            k--;
                        }
                        if (isequal||k<0){
                            flag = false;
                        }
                    }
                    else {
                        break;
                    }
                }
                if (flag&&i == A.length -2 ){
                    B[j] =true;
                    //len++;
                }
            }
            j++;
        }
        for (boolean b : B) {
            if(!b){
                len++;
            }
        }
        return A[0].length()-len;
    }

    public int minDeletionSize(String[] A) {
        if (A.length <=1){
            return 0;
        }
        int j = 0;
        int len = 0;
        boolean[] B = new boolean [A[0].length()];
        while (j<A[0].length()){
            boolean flag = true;
            for (int i = 0; i < A.length-1; i++) {
                if (A [i].charAt(j)>A[i+1].charAt(j)){
                    if (j!=0){
                        //去左边找，如果是true
                        int k = j-1;
                        while (k>=0){
                            if (B[k]){
                                if (A[i].charAt(k)!=A[i+1].charAt(k)){
                                    break;
                                }
                            }
                            k--;
                        }
                        if (k<0){
                            flag = false;
                        }
                    }
                    else {
                        break;
                    }
                }
                if (flag&&i == A.length -2 ){
                    B[j] =true;
                }
            }
            j++;
        }
        for (boolean b : B) {
            if(!b){
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        minDeletionSize m = new minDeletionSize();
        String [] A = {"bbjwefkpb","axmksfchw"};
        System.out.println(m.minDeletionSize(A));
    }
}
