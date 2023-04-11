package com.od.OD.OD100;

import java.util.Scanner;

public class OD_16_0 {

    public static int manjian;
    public static int dazhe;
    public static int wumenkan;
    //ȯ����Сʹ����
    public static int mincountQuan;
    //���ټ۸�
    public static int minCount;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        manjian = sc.nextInt();
        dazhe = sc.nextInt();
        wumenkan = sc.nextInt();

        int n = sc.nextInt();

        for(int i=0; i<n; i++){

            double money = sc.nextInt();

            //����ʹ������������
            int quanMJ = money/100 > manjian ? manjian : (int) (money / 100);

            //ʹ�����ż���ȯ������
            int quanWMK;
            //ȯ����Сʹ����
            mincountQuan = Integer.MAX_VALUE;
            //���ټ۸�
            minCount = Integer.MAX_VALUE;

            if(dazhe > 0){  //�д���ȯ�����

                //�����������
                int MJafterDZ = (int) Math.floor(Manjian(money) * 0.92);
                flush( MJafterDZ, quanMJ + 1);

                //�ȴ��ۺ�����
                int DZafterMJ = (int) Math.floor(Manjian(money * 0.92));
                //�ȴ��ۺ�����������ȯ
                int quanDZafterMJ = (int) (money * 0.92 / 100 > manjian ? manjian : money * 0.92 / 100);
                flush( DZafterMJ, quanDZafterMJ + 1);

                //�ȴ��ۺ����ż�
                double dazhe = money * 0.92;
                //���ż���Ҫ������
                quanWMK = wumenkan(dazhe);
                int dazheWMK;
                if(dazhe <= quanWMK * 5){
                    //���ۺ�ļ۸�С�ڵ������ż���ȫ���۸񣨿���0Ԫ����
                    dazheWMK = 0;
                }else {
                    dazheWMK = (int) Math.floor(dazhe - quanWMK * 5);
                }
                flush( dazheWMK, quanWMK + 1);

                //�����ż������
                int wmkDZ;
                //���ż���Ҫ������
                quanWMK = wumenkan(money);
                if(money <= quanWMK * 5 ){
                    //�۸�С�ڵ������ż���ȫ���۸񣨿���0Ԫ����
                    flush( 0, quanWMK);
                }else {
                    wmkDZ = (int) Math.floor((money - quanWMK * 5) * 0.92);
                    flush( wmkDZ, quanWMK + 1);
                }
            }

            //�����������ż�
            int mjWMK;
            double manjian= Manjian(money);
            //���ż���Ҫ������
            quanWMK =  wumenkan(manjian);
            if(manjian <= quanWMK * 5){
                //������ļ۸�С�ڵ������ż���ȫ���۸񣨿���0Ԫ����
                mjWMK = 0;
            }else {
                mjWMK = (int) Math.floor(manjian - quanWMK * 5);
            }
            flush( mjWMK, quanWMK + quanMJ);

            System.out.println(minCount + " " + mincountQuan);

        }
    }

    /**
     * ˢ�����ټ۸������ʹ��ȯ
     * @param count
     * @param quanCount
     */
    public static void flush(int count, int quanCount){
        if(count < minCount){
            minCount = count;
            mincountQuan = quanCount;
        }else if(count == minCount){
            mincountQuan = Math.min( quanCount, mincountQuan);
        }
    }

    /**
     * �����Ҫ���ż��Ż�ȯ������
     * @param money
     * @return
     */
    public static int wumenkan(double money){

        for(int i=1; i<=wumenkan; i++){
            if(money <= 5 * i) {
                return i;
            }
        }

        return wumenkan;
    }

    /**
     * ������ļ۸�
     * @param money
     * @return
     */
    public static double Manjian(double money){

        if(money/100 >= manjian){
            return money - manjian*10;
        }else {
            return money - ((int) money/100)*10;
        }
    }
}
