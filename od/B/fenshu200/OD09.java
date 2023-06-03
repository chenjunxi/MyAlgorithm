package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
5 6
1 2 0
1 2 1
1 5 0
2 3 1
2 5 1
1 3 2

5 4
1 3 0
2 5 0
1 2 0
3 5 1


思路就是集合的retainAll来判断是否交集，如果有2个集合之间都有交集，那么这两个集合也要合并，并删除其中一个
* */
public class OD09 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
        List<List<Integer>> teams = new ArrayList<>(); //所有teams的集合

        if (n < 1 || n > 100000 || m < 1 || m > 100000) { //越界了
            System.out.println("NULL");
        } else {
            for (int i = 0; i < m; i++) {

                String[] str = sc.nextLine().split(" ");

                int a = Integer.valueOf(str[0]);
                int b = Integer.valueOf(str[1]);
                int c = Integer.valueOf(str[2]);

                List<Integer> team = new ArrayList<>();
                team.add(a);
                team.add(b);

                if (a < 1 || a > n || b < 1 || b > n || (c != 0 && c != 1)) { //a,b越界，c只能0和1
                    System.out.println("da pian zi");
                } else if (c == 0) {
                    boolean hasTeam = false;    //a和b是否有了team
                    ArrayList<Integer> indexList = new ArrayList<>();

                    for (int j = 0; j < teams.size(); j++) {
                        List<Integer> list = teams.get(j);
                        ArrayList<Integer> list1 = new ArrayList<>(list);
                        list1.retainAll(team);
                        if (list1.size() > 0) {
                            list.addAll(team);
                            hasTeam = true;
                            indexList.add(j);
                        }
                    }

                    //新来的集合是否和原来的集合有染个数等于2，有染只能1个或者2个
                    if (indexList.size() == 2) {
                        List<Integer> integers = teams.get(indexList.get(0));
                        integers.addAll(teams.get(indexList.get(1)));
                        teams.remove(indexList.get(1));
                    }


                    if (!hasTeam) {   //a和b都没有team，则新建team加入teams的集合中
                        teams.add(team);
                    }
                } else {
                    boolean isATeam = false;
                    for (int j = 0; j < teams.size(); j++) {
                        if (teams.get(j).contains(a) && teams.get(j).contains(b)) {   //a和b同时在一个team中
                            isATeam = true;
                        }
                    }
                    System.out.println(isATeam ? "we are a team" : "we are not a team");
                }
            }
        }
    }
}
