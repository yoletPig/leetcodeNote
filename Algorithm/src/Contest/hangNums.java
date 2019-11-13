package Contest;

public class hangNums {
    public void hangNums(int n){
        int count = 0;
        //计算n后面勾股数的数量
        for (int i = 0; i <= 20; i++) {
            //4个勾股数出现的范围一定是[n,n+20]
            if (findhang(n+i)){
                //如果是勾股数count++
                count++;
                //打印
                System.out.println(n+i);
            }
            if (count>=4){
                break;
            }
        }
    }

    private boolean findhang(int n) {
        //5的倍数一定是勾股数
        if (n%5==0){
            return true;
        }
        else {
            int i = n-1;
            while (i>0){
                //i是另一条边 n*n = i*i + x
                //如果x开方为整数就返回true
                if (Math.sqrt(n*n-i*i)-(int)Math.sqrt(n*n-i*i)==0){
                    return true;
                }
                i--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        hangNums hm = new hangNums();
        hm.hangNums(15);
    }
}
