package com.digiwin.practice;

import com.digiwin.practice.ui.DisplayUI;

import java.util.Scanner;

public class DAPJavaPractice_01810_2 {
    public static void main(String[] args) {

        DisplayUI MyUI = new DisplayUI();

        /*System.out.println("***** DAP Java 練習題二 *****");
        System.out.println("==========================");
        System.out.println("銷 售 紀 錄 管 理 系 統");

        System.out.println("--------------------------");
        System.out.println("1.查 詢");
        System.out.println("2.新 增");
        System.out.println("3.修 改");
        System.out.println("4.刪 除");
        System.out.println(" ");
        System.out.println("9.退 出");
        System.out.println("==========================");*/
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        while(i == 1){
            while (!scanner.hasNextInt()) {
                System.out.println(" ***[ERROR]輸入錯誤，只能為:[1, 2, 3, 4, 9]***");
                scanner.nextLine();
            }
            int Ordertype = scanner.nextInt();
            switch(Ordertype) {
                case 1:
                    System.out.println("1.順序類型=升冪-1");

                    System.out.println("--------------------");
                    System.out.print(">>> 請輸入執行類型>");
                    break;
                case 2:
                    System.out.println("2.順序類型=降冪-2");

                    System.out.println("--------------------");
                    System.out.print(">>> 請輸入執行類型>");
                    break;
                case 3:
                    System.out.println("3.順序類型=反轉-3");

                    System.out.println("--------------------");
                    System.out.print(">>> 請輸入執行類型>");
                    break;
                case 4:
                    System.out.println("3.順序類型=反轉-3");

                    System.out.println("--------------------");
                    System.out.print(">>> 請輸入執行類型>");
                    break;
                case 9:
                    break;
                default:
                    System.out.println("***[ERROR]輸入錯誤，只能為:[1, 2, 3, 4, 9]***");
                    System.out.println("--------------------");
                    System.out.print(">>> 請輸入執行類型>");
            }
            if (Ordertype == 9)   //退出
            {
                System.out.println("退出系統。");
                System.out.println("=========================");
                break;
            }
        }
    }
}
