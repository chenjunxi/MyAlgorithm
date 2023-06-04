package com.od.B.fenshu100;

import scala.Int;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*最大花费金额
固定金额，固定买三件，求花费最大的组合
23,26,3,6,27
78
输出76

23,30,40
26
输出-1


思路：可以考虑使用回溯
* */
public class OD08 {
    public static int max = -1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(",");
        int[] M = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        int R = sc.nextInt();
        Arrays.sort(M);
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(path, M, R, 0, 0);

        System.out.println(max);

    }

    private static void dfs(ArrayDeque<Integer> path, int[] m, int target, int index, int sum) {
        if (path.size() == 3) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = index; i < m.length; i++) {
            if (sum + m[i] > target) {
                break;
            }

            sum += m[i];
            path.add(m[i]);
            dfs( path, m, target, i + 1, sum);
            sum -= m[i];
            path.removeLast();
        }
    }

    private static void demo(int[] m, int r) {
        int len = m.length;
        Arrays.sort(m);
        int sum = 0;
        for (int i = len - 1; i >= 2; i--) {
            if (m[i] > r) {
                continue;
            }
            for (int j = i - 1; j >= 1; j--) {
                if (m[i] + m[j] > r) {
                    continue;
                }
                for (int k = j - 1; k >= 0; k--) {
                    int temp = m[i] + m[j] + m[k];
                    if (temp <= r && temp > sum) {
                        sum = temp;
                    }
                }
            }
        }

        System.out.println(sum == 0 ? -1 : sum);
    }
}
