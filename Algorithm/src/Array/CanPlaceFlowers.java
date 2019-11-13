package Array;
/*
605 种花问题，缺点：思维长度太短！
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int j=0;
        int sum=0;
        boolean flag = true;
        if (flowerbed.length==1&&flowerbed[0]==0){
            return true;
        }
        for (int i = 0; i < flowerbed.length;) {
            if (flowerbed[i]==1){
                if (i<=1){
                    flag = false;
                }
                if (sum==0&&i>1&&flag){
                    sum+=i/2;
                }
                j=i+1;
                while (j<flowerbed.length&&flowerbed[j]==0){
                    j++;
                }
                if (j==flowerbed.length||j-i-1>2){
                    if (j==flowerbed.length){
                        sum += (j-i-1)/2;

                    }
                    else
                    {
                        sum += (j-i-2)/2;

                    }
                }
                i=j;
                j=0;
            }
            else {
                i++;
                if (i==flowerbed.length){
                    sum+=(i+1)/2;
                }
            }
            if (sum>=n){
               // System.out.println(sum);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,0,0,0,1,0,0};
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(a,2));
    }
}
