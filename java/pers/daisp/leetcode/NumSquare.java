package pers.daisp.leetcode;

import pers.daisp.util.NumberUtil;

import java.util.*;

public class NumSquare {

    private static int solution(int number) {
        int maxItem = Double.valueOf(Math.sqrt(number)).intValue();
        int[] squareArr = new int[maxItem];
        Map<Integer, Integer> results = new HashMap<>();
        for (int i = 1; i <= maxItem; i++) {
            if ( i * i == number) return 1;
            squareArr[i - 1] = i * i;
            results.put(squareArr[i - 1], 1);
        }
        while (true) {
            Map<Integer, Integer> tempMap = new HashMap<>(results);
            for (int i = 0; i < maxItem; i++) {
                for (Map.Entry<Integer, Integer> item : tempMap.entrySet()) {
                    int temp = squareArr[i] + item.getKey();
                    if (!results.containsKey(temp)) {
                        if (temp == number) return item.getValue() + 1;
                        results.put(temp, item.getValue() + 1);
                    }
                }
            }
        }
    }

    private static int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        // 创建 set 来存放非重复的元素
        Set<Integer> visited = new HashSet<>();
        queue.offer(n);
        // 定义 level 记录完全平方数的个数
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            // 每次有元素入队就代表还有剩余子平方数
            level++;
            for (int i = 0; i < len; i++) {
                int node = queue.poll();
                // 从 1 开始取，每次拿平方数来比较
                for (int j = 1; j * j <= node; j++) {
                    // 用当前结点减去平方数 1,4,9...
                    int next = node - j * j;
                    // 找完所有的平方数即可返回
                    if (next == 0) {
                        return level;
                    }
                    // 如果 set 里面没有存放当前元素，则可以入队,入 set
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int number = NumberUtil.createRandomInt(20);
            System.err.println(number + ": " + solution(number));
        }
    }
}
