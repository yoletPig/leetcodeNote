package Contest;

/**
 * 153 周赛
 * 5181. 公交站间的距离  显示英文描述  我的提交返回竞赛
 * 用户通过次数 829
 * 用户尝试次数 870
 * 通过次数 839
 * 提交次数 1563
 * 题目难度 Easy
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 */
public class distanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        int con = 0;
        if (start>destination){
            int temp = start;
            start = destination;
            destination = temp;
        }
        for (int i = 0; i < distance.length; i++) {
            if (i>=start&&i<destination){
                con+=distance [i];
            }
            sum += distance [i];
        }
        return sum-con > con ? con : sum-con;
    }

    public static void main(String[] args) {
        distanceBetweenBusStops dsi = new distanceBetweenBusStops();
        int [] distance = {3,6,7,2,9,10,7,16,11};
        System.out.println(dsi.distanceBetweenBusStops(distance,6,2));
    }
}
