package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OD03 {
    public static List<String[]> list = new ArrayList<>();    //依赖关系集合
    public static List<String> errorSer = new ArrayList<>();   //故障集合

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(",");
        String[] guzhang = sc.nextLine().split(",");

        List<String> setSer = new ArrayList<>();     //所有服务集合（取出错误服务）
        errorSer = Arrays.asList(guzhang);

        for (int i = 0; i < strings.length; i++) {

            String[] temp = strings[i].split("-");

            list.add(temp);
            String a = temp[0];
            String b = temp[1];

            if (!errorSer.contains(a) && !setSer.contains(a)) {
                setSer.add(a);
            }
            if (!errorSer.contains(b) && !setSer.contains(b)) {
                setSer.add(b);
            }
        }

        List<String> listZC = new ArrayList<>();    //保持正常的服务

        setSer.forEach(v -> {
            if (!isGz(v)) {      //如果非故障则取出
                listZC.add(v);
            }
        });

        int len = listZC.size();
        if (len == 0) {
            System.out.println(",");
        } else {
            String res = "";
            for (int i = 0; i < len; i++) {
                res += listZC.get(i);
                if (i != len - 1) {
                    res += ",";
                }
            }
            System.out.println(res);
        }
    }

    public static boolean isGz(String s) {  //服务依赖关系集合，需要判断的服务，故障服务集合
        if (errorSer.contains(s)) { //此时服务故障则返回true
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0].equals(s) && isGz(list.get(i)[1])) {    //如果此时服务依赖另外一个服务，则对依赖的服务进行一次故障判断，如为故障则返回true
                return true;
            }
        }
        return false;
    }
}
