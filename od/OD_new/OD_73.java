package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.Scanner;
//异常打卡记录
//record转成类保存，两两遍历对比，首先不同设备的即为异常同时不参加后面的比较。同ID的再比较时间和距离
public class OD_73 {
    static class Record {
        int id;
        int time;
        int distance;
        String AID;
        String RID;

        public Record(int id, int time, int distance, String AID, String RID) {
            this.id = id;
            this.time = time;
            this.distance = distance;
            this.AID = AID;
            this.RID = RID;
        }

        @Override
        public String toString() {
            return id + "," + time + "," + distance + "," + AID + "," + RID;
        }


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer N = Integer.valueOf(sc.nextLine());
        ArrayList<Record> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] split = sc.nextLine().split(",");
            list.add(new Record(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]), split[3], split[4]));
        }


        ArrayList<String> resList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Record record01 = list.get(i);

            if (!record01.RID.equals(record01.AID)) {
                resList.add(record01.toString());
                continue;
            }

            for (int j = i + 1; j < list.size(); j++) {
                Record record02 = list.get(j);

                //基于设备号相同情况下比较
                if (!record02.RID.equals(record02.AID)) {
                    resList.add(record02.toString());
                    list.remove(j);
                    continue;
                }

                int id1 = record01.id;
                int id2 = record02.id;
                int time1 = record01.time;
                int time2 = record02.time;
                int distance1 = record01.distance;
                int distance2 = record02.distance;

                if (id1 == id2) {
                    int timesub = Math.abs(time1 - time2);
                    int distancesub = Math.abs(distance1 - distance2);
                    if (timesub < 60 && distancesub > 5) {
                        resList.add(record01.toString());
                        resList.add(record02.toString());
                        break;  //考虑是否存在同一个ID 有3条记录的情况

                    }
                }
            }

        }

        if (resList.size() == 0) {
            System.out.println("null");
        } else {
            for (int i = 0; i < resList.size() - 1; i++) {
                System.out.print(resList.get(i) + ";");
            }
            System.out.println(resList.get(resList.size() - 1));
        }


    }
}
