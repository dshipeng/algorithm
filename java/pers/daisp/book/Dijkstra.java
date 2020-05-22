package pers.daisp.book;

public class Dijkstra {

    public static void main(String[] args) {
        final int M = 1000; // 代表正无穷
        // 二维数组每一行分别是 A、B、C、D、E 各点到其余点的距离,
        // A -> A 距离为0, 常量M 为正无穷
        int[][] graph = {
                {0, 4, M, 2, M},
                {4, 0, 4, 1, M},
                {M, 4, 0, 1, 3},
                {2, 1, 1, 0, 7},
                {M, M, 3, 7, 0}
        };
        int start = 0;
        int[] shortPath = DijkstraPath(graph);
        for (int i = 0; i < shortPath.length; i++) {
            System.out.println("从" + start + "出发到" + i + "的最短距离为：" + shortPath[i]);
        }
    }


    private static int[] DijkstraPath(int[][] graph) {
        int length = graph.length;
        int[] s = new int[length];
        s[0] = 0;
        int[] u = new int[length];
        u[0] = 0;
        for (int i = 1; i < length; i++) {
            u[i] = graph[0][i];
        }
        for (int j = 1; j < length; j++) {
            int min = 1000;
            int index = -1;
            for (int x = 0; x < length; x++) {
                if (u[x] <= min && u[x] != 0) {
                    index = x;
                    min = u[x];
                }
            }
            s[index] = u[index];
            u[index] = 0;
            for (int y = 0; y < length; y++) {
                if (u[y] != 0) {
                    if (u[y] > s[index] + graph[index][y]) {
                        u[y] = s[index] + graph[index][y];
                    }
                }
            }
        }
        int[] paths = new int[length];
        for (int tmp = 0; tmp < length; tmp++) {
            paths[tmp] = s[tmp];
        }
        return paths;
    }

}
