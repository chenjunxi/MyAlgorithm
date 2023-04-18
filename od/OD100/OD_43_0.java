package com.od.OD.OD100;

import java.util.ArrayList;
import java.util.Scanner;

public class OD_43_0 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        //处理器数组
        int[] vis = new int[10];

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.substring(1, s.length() - 1).split(", ");
        //链路1可用的处理器个数
        int v1 = 0;
        //链路2可用的处理器个数
        int v2 = 0;
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i].trim();
            if ("".equals(str)) {
                continue;
            }
            int t = Integer.parseInt(str);
            vis[t] = 1;
            if (t < 4) {
                v1++;
            } else {
                v2++;
            }
        }

        int val = scanner.nextInt();
        if (val == 1) {
            //申请1个处理器
            int state = 0;
            //亲和度判断
            if (v1 == 1 || v2 == 1) state = 1;
            else if (v1 == 3 || v2 == 3) state = 3;
            else if (v1 == 2 || v2 == 2) state = 2;
            else if (v1 == 4 || v2 == 4) state = 4;
            if (v1 == state) {
                for (int i = 0; i < 4; i++) {
                    if (vis[i] == 1) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        ans.add(tmp);
                    }
                }
            }
            if (v2 == state) {
                for (int i = 4; i < 8; i++) {
                    if (vis[i] == 1) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        ans.add(tmp);
                    }
                }
            }
        } else if (val == 2) {
            //申请2个处理器
            int state = 0;
            if (v1 == 2 || v2 == 2) state = 2;
            else if (v1 == 4 || v2 == 4) state = 4;
            else if (v1 == 3 || v2 == 3) state = 3;
            if (v1 == state) {
                for (int i = 0; i < 4; i++) {
                    for (int j = i + 1; j < 4; j++) {
                        if (i != j && vis[i] == 1 && vis[j] == 1) {
                            ArrayList<Integer> tmp = new ArrayList<>();
                            tmp.add(i);
                            tmp.add(j);
                            ans.add(tmp);
                        }
                    }
                }
            }
            if (v2 == state) {
                for (int i = 4; i < 8; i++) {
                    for (int j = i + 1; j < 8; j++) {
                        if (i != j && vis[i] == 1 && vis[j] == 1) {
                            ArrayList<Integer> tmp = new ArrayList<>();
                            tmp.add(i);
                            tmp.add(j);
                            ans.add(tmp);
                        }
                    }
                }
            }
        } else if (val == 4) {
            //申请4个处理器
            if (v1 == 4) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    tmp.add(i);
                }
                ans.add(tmp);
            }
            if (v2 == 4) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = 4; i < 8; i++) {
                    tmp.add(i);
                }
                ans.add(tmp);
            }
        } else if (val == 8) {
            //申请8个处理器
            if (v1 == 4 && v2 == 4) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < 8; i++) {
                    tmp.add(i);
                }
                ans.add(tmp);
            }
        }

        System.out.println(ans);
    }
}
