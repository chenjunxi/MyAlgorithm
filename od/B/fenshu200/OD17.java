package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OD17 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        //面试集合
        List<Interview> msList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Interview interview = new Interview(sc.nextInt(), sc.nextInt());
            msList.add(interview);
        }
        //对面试场次进行排序
        Collections.sort(msList);
        //面试官集合
        List<List<Interview>> msgList = new ArrayList<>();
        for (Interview ms : msList) {
            //面试的开始时间
            int start = ms.start;
            //是否成功进行面试
            boolean isSuccess = false;
            for (List<Interview> msg : msgList) {
                if (msg.size() == m) {
                    //面试官的面试场次满了
                    continue;
                }
                if (msg.get(msg.size() - 1).end <= start) {
                    //面试的开始时间大于等于面试官上场面试的结束时间
                    msg.add(ms);
                    //说明成功进行面试
                    isSuccess = true;
                    break;
                }
            }
            if (!isSuccess) {
                //没有成功进行面试，需要新加面试官
                List<Interview> newList = new ArrayList<>();
                newList.add(ms);
                msgList.add(newList);
            }
        }
        //输出面试官的个数
        System.out.println(msgList.size());
    }

    static class Interview implements Comparable<Interview> {

        int start;
        int end;

        public Interview(int start, int end) {

            this.start = start;
            this.end = end;

        }

        @Override
        public int compareTo(Interview o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
