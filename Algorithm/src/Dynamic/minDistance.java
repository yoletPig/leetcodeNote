package Dynamic;

public class minDistance {
    public int minDistance(String word1, String word2) {
        String s = word1;
        if (word1.length()>word2.length()){
            word1 = word2;
            word2 = s;
        }
        //ch在word2中的位置
        int[] position = new int[word1.length()];
        //ch在这个位置上的最长公共子序列
        int[] count = new int[word1.length()];
        for (int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            int max=0;
            if (word2.indexOf(ch)==-1){
                position[i]=-1;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (position[j]==-1||position[j]==word2.length()-1){
                    if(position[i]==0){
                        position [i] = word2.indexOf(ch);
                        count[i] = 1;
                    }
                    continue;
                }
                int temp = findpos(position[j],ch,word2);
                if (temp!=-1){
                    if (count[j]>=max){
                        max = count [j];
                        position [i] = temp;
                    }
                }else {
                    if (j==i-1){
                        count [i] = 1;
                        position [i] = word2.indexOf(ch);
                    }else {
                        continue;
                    }
                }
            }

            if (position[i]!=-1)
            {
                if(i==0){
                    position[i] = word2.indexOf(ch);
                    count [i] = 1;
                }else
                {
                    count [i] = max+1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count [i] > max){
                max=count [i];
            }
        }
        return word1.length()+word2.length()-2*max;
    }

    private int findpos(int begin,char ch,String word2){
        if (begin==word2.length()-1){
            return -1;
        }
        word2 = word2.substring(begin+1);
        if (word2.indexOf(ch)==-1){
            return -1;
        }
        return word2.indexOf(ch)+begin+1;
    }


    /*public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    continue;
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return s1.length() + s2.length() - 2 * dp[s1.length()][s2.length()];
    }*/

    public static void main(String[] args) {
        minDistance mm = new minDistance();
        System.out.println(mm.minDistance("benzalphenylhydrazone","dinitrophenylhydrazine"));
    }
}


















