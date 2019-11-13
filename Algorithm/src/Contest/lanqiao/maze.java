package Contest.lanqiao;
import	java.util.Scanner;

public class maze {
    //上，右，下，左
    int[][] ways = {{-1,0},{0,1},{1,0},{0,-1}};
    int sum = 0;
    void fun(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int T = in.nextInt();
        //构建迷宫地图
        int[][] arr = new int[N][M];
        //起始坐标
        //保存起始坐标
        int SX = in.nextInt()-1;
        int SY = in.nextInt()-1;
        arr[SX][SY] = 1;
        //终点坐标
        arr[in.nextInt()-1][in.nextInt()-1] = 2;
        while (T>0){
            //障碍坐标
            arr[in.nextInt()-1][in.nextInt()-1] = 3;
            T--;
        }
        dfs(arr,SX,SY);
        System.out.println(sum);
    }

    private void dfs(int[][] arr, int sx, int sy) {
        for (int i = 0; i < ways.length; i++) {
            int t_x = sx+ways[i][0];
            int t_y = sy+ways[i][1];
            if (t_x>=0&&t_x<arr.length && t_y>=0&&t_y<arr[0].length){
                if (arr[t_x][t_y]==2){
                    sum++;
                }
                if (arr[t_x][t_y]==0){
                    int[][] temp_arr = new int[arr.length][arr[0].length];
                    for (int j = 0; j < arr.length; j++) {
                        for (int k = 0; k < arr[j].length; k++) {
                            temp_arr[j][k] = arr[j][k];
                        }
                    }
                    temp_arr[t_x][t_y] = 4;
                    dfs(temp_arr,t_x,t_y);
                }
            }
        }
    }

    public static void main(String[] args) {
        maze m = new maze();
        m.fun();
    }
}
