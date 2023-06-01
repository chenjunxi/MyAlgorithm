package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

                if (a < 1 || a > n || b < 1 || b > n || (c != 0 && c != 1)) { //a,b越界，c只能0和1
                    System.out.println("da pian zi");
                } else if (c == 0) {
                    boolean hasTeam = false;    //a和b是否有了team
                    int teamIndex = -1;
                    boolean isCombine = false;    //是否进行过合并
                    for (int j = 0; j < teams.size(); j++) {
                        if (teams.get(j).contains(a)) {   //team中有了a，则b也是其中成员
                            teams.get(j).add(b);
                            if (hasTeam) {    //已经有了team，可以进行合并
                                teams.get(j).removeAll(teams.get(teamIndex));
                                teams.get(j).addAll(teams.get(teamIndex));
                                isCombine = true;
                                break;
                            }
                            teamIndex = j;
                            hasTeam = true;
                            continue;
                        }
                        if (teams.get(j).contains(b)) {   //team中有了b，则a也是其中成员
                            teams.get(j).add(a);
                            if (hasTeam) {
                                teams.get(j).removeAll(teams.get(teamIndex));
                                teams.get(j).addAll(teams.get(teamIndex));
                                isCombine = true;
                                break;
                            }
                            teamIndex = j;
                            hasTeam = true;
                        }
                    }
                    if (isCombine) {
                        teams.remove(teamIndex);    //剔除合并过的team
                    }
                    if (!hasTeam) {   //a和b都没有team，则新建team加入teams的集合中
                        List<Integer> team = new ArrayList<>();
                        team.add(a);
                        team.add(b);
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
