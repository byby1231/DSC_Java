//package com.digiwin.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 練習題一 - 範例 20200910
 * @author 陳俊良
 */
public class DAPJavaPractice_00320_1 {

    /**
     * 順序類型 - 升冪
     */
    private static final int ORDER_TYPE_ASC = 1;
    /**
     * 順序類型 - 降冪
     */
    private static final int ORDER_TYPE_DESC = 2;
    /**
     * 順序類型 - 反轉
     */
    private static final int ORDER_TYPE_REVERSE = 3;
    /**
     * 順序類型 - 退出程序
     */
    private static final int ORDER_TYPE_EXIT = 0;

    public static void main(String[] args) {

        // 練習題一的實作內容
        int datas[] = new int[] { 2, 6, 3, 5, 1, 4 };

        System.out.println("***** DAP Java 練習題一 *****");
        System.out.println("* 來源資料: " +  Arrays.toString(datas));
        System.out.println("* 開始排序...輸入範圍 1 到 4，退出程序使用 0");
        System.out.println("=========================");

        int exeType;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print(">>> 請輸入執行類型>");
            exeType = scanner.nextInt();

            if (exeType == ORDER_TYPE_EXIT) {

                System.out.println("..退出循環");
                break;
            }

            sort(exeType, datas);
        }

        System.out.println("=========================");
        System.out.println("* 結束排序...");
        System.out.println("* 來源資料: " +  Arrays.toString(datas));
        System.out.println("***** DAP Java 練習題一 *****");
    }

    private static int count = 1;

    /**
     * 排序方式
     * @param orderType 順序類型
     * @param datas 數據
     */
    private static void sort(int orderType, int[] datas) {

        int[] cloneDatas = datas.clone();
        boolean notSupport = false;
        String orderTypeDisplayName;
        switch(orderType) {
            case ORDER_TYPE_ASC:
                orderTypeDisplayName = "升冪";
                break;
            case ORDER_TYPE_DESC:
                orderTypeDisplayName = "降冪";
                break;
            case ORDER_TYPE_REVERSE:
                orderTypeDisplayName = "自訂";
                break;
            default:
                orderTypeDisplayName = "未知";
                notSupport = true;
                break;
        }

        System.out.println(count++ + ".順序類型=" + orderTypeDisplayName + "-" + orderType);
        if  (notSupport) {

            System.out.println("..目前不支持此順序類型的排序!");
            System.out.println("--------------------");
            return;
        }

        System.out.println("..排序前: " + Arrays.toString(cloneDatas));

        int swapTemp;
        if (orderType == ORDER_TYPE_REVERSE) {

            for(int i = 0; i < cloneDatas.length / 2; i++)
            {
                swapTemp = cloneDatas[i];
                cloneDatas[i] = cloneDatas[cloneDatas.length - i - 1];
                cloneDatas[cloneDatas.length - i - 1] = swapTemp;
            }
        }
        else {

            boolean asc = orderType == ORDER_TYPE_ASC;
            for (int i = 0; i < cloneDatas.length; i++) {

                for (int j = 0; j < cloneDatas.length - 1; j++) {

                    if (asc ? (cloneDatas[j] > cloneDatas[j + 1]) : (cloneDatas[j] < cloneDatas[j + 1])) {

                        swapTemp = cloneDatas[j];
                        cloneDatas[j] = cloneDatas[j + 1];
                        cloneDatas[j + 1] = swapTemp;
                    }
                }
            }
        }

        System.out.println("..排序後: " + Arrays.toString(cloneDatas));
        System.out.println("--------------------");
    }
}
