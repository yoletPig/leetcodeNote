package Contest.lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class world_Square {
    int n = 0;
    boolean[][] flag = new boolean[100][100];
    String s = "yizhong";
    void f(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        this.n = n;
        String[] strs = new String[n];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = in.next();
        }
        //左上，上，右上，右，右下，下，左下，左
        int[][] move = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j)=='y'){
                    dfs(strs,move,i,j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (flag[i][j] == true){
                    if (j!=n-1)
                    {
                        System.out.print(strs[i].charAt(j)+"");
                    }else {
                        System.out.println(strs[i].charAt(j));
                    }
                }else {
                    if (j!=n-1)
                    {
                        System.out.print("*");
                    }
                    else {
                        System.out.println("*");
                    }
                }
            }
        }
    }

    void dfs(String[]strs,int[][] move,int i,int j){
        int temp_i = i;
        int temp_j = j;
        for (int k = 0; k < 8; k++) {
            int index = 0;
            List<int[]> list = new ArrayList();
            i = temp_i;
            j = temp_j;
            while (i<n&&i>=0&&j>=0&&j < n){
                if (index<7&&strs[i].charAt(j)==s.charAt(index)){
                    int[] arr = {i,j};
                    list.add(arr);
                    index++;
                }
                if (index>=7){
                    int num = 0;
                    for (int[] arr : list) {
                        if (flag[arr[0]][arr[1]]){
                            num++;
                        }
                    }
                    if (num<6||n==100){
                        for (int[] arr : list) {
                            flag[arr[0]][arr[1]]=true;
                        }
                    }
                    break;
                }
                i+=move[k][0];
                j+=move[k][1];
            }
        }
    }

    public static void main(String[] args) {
        world_Square m = new world_Square();
        m.f();
    }
}

