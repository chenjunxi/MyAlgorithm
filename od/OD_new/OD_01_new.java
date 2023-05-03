package com.od.OD.OD130;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*最大化控制资源成本 200分 参考：leetcode 253
 求最少需要的服务器数量
3
2 3 1
6 9 2
0 5 1
* */
public class OD_01_new {
    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] ranges = new int[n][3];
        for (int i = 0; i < n; i++) {
            ranges[i][0] = in.nextInt();
            ranges[i][1] = in.nextInt();
            ranges[i][2] = in.nextInt();
        }

        System.out.println(minMeetingRooms(ranges));
    }

    public static int minMeetingRooms(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int res = 0;
        int temp_res = 0;
        for (int i = 0; i < ranges.length; i++) {
            while (pq.size() > 0) {
                Integer[] top = pq.peek();

                if (top[0] < ranges[i][0]) {
                    Integer[] poll = pq.poll();
                    temp_res -= poll[1];
                } else {
                    break;
                }
            }

            pq.offer(new Integer[]{ranges[i][1], ranges[i][2]});
            temp_res += ranges[i][2];

            if (temp_res > res) {
                res = temp_res;
            }
        }
        return res;
    }
}
