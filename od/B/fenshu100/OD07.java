package com.od.B.fenshu100;

import java.util.*;

public class OD07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] one = sc.nextLine().split(";");
        String[] two = sc.nextLine().split(";");

        Map<String, List<Student>> map = new HashMap<>();
        for (int i = 0; i < one.length; i++) {

            String[] oneStu = one[i].split(",");
            //学生学号
            String oneStuId = oneStu[0];

            for (int j = 0; j < two.length; j++) {

                String[] twoStu = two[j].split(",");
                //学生学号
                String twoStuId = twoStu[0];

                if (oneStuId.equals(twoStuId)) {

                    int oneStuScore = Integer.parseInt(oneStu[1]);
                    int twoStuScore = Integer.parseInt(twoStu[1]);
                    //总成绩
                    int totalScore = oneStuScore + twoStuScore;
                    //班级编号
                    String cla = twoStuId.substring(0, 5);
                    //学生信息
                    Student student = new Student(oneStuId, totalScore);
                    if (map.containsKey(cla)) {
                        map.get(cla).add(student);
                    } else {
                        List<Student> list = new ArrayList<>();
                        list.add(student);
                        map.put(cla, list);
                    }
                }
            }
        }

        if (map.size() == 0) {
            //没有符合要求的
            System.out.println("NULL");
        } else {
            List<Map.Entry<String, List<Student>>> mapList = new ArrayList<>(map.entrySet());
            mapList.sort((a, b) -> {
                if (a.getKey().compareTo(b.getKey()) < 0) {
                    return -1;
                }
                return 1;
            });

            for (Map.Entry<String, List<Student>> m : mapList) {
                //输出班级编号
                System.out.println(m.getKey());
                String res = "";
                //对学生按照要求排序
                Collections.sort(m.getValue());
                for (Student s : m.getValue()) {
                    res += s.stuId + ";";
                }
                System.out.println(res.substring(0, res.length() - 1));
            }
        }

    }

    static class Student implements Comparable<Student> {

        String stuId;
        int score;

        public Student(String stuId, int score) {
            this.stuId = stuId;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            if (this.score > o.score) {
                return -1;
            } else if (this.score == o.score) {
                if (this.stuId.compareTo(o.stuId) > 0) {
                    return 1;
                }
                return -1;
            }
            return 1;
        }
    }
}
