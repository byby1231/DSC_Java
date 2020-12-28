package com.digiwin.practice.ui;

import com.digiwin.practice.pojo.SalesRecord;
import com.digiwin.practice.service.SearchSaleRecord;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DisplayUI {
    public DisplayUI() {

    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    public void ShowWelcomeMessage(){
        System.out.println("***** DAP Java 練習題二 *****");
        System.out.println("==========================");
        System.out.println("銷 售 紀 錄 管 理 系 統");

        System.out.println("--------------------------");
        System.out.println("1.查 詢");
        System.out.println("2.新 增");
        System.out.println("3.修 改");
        System.out.println("4.刪 除");
        System.out.println(" ");
        System.out.println("9.退 出");
        System.out.println("==========================");
    }

    private void ShowBrowserMainMenu(){
        System.out.println("==========================");
        System.out.println("        銷 售 紀 錄 列 表");
        System.out.println("        1. 數量由小到大排序");
        System.out.println("        2. 數量由大到小排序");
        System.out.println("--------------------------");
        System.out.println("請輸入排序方式, 不輸入時不排序:");
    }
    public void ShowBrowserTitle(){
        System.out.println("--------------------------");
        System.out.println("編號    日期    數量");
        System.out.println("--------------------------");
    }

    public void ShowEditTitle(){
        System.out.println("==========================");
        System.out.println("        編 輯 銷 售 紀 錄");
        System.out.println("--------------------------");
    }


    public void ShowEditMessage(ArrayList<SalesRecord> xList) {

        this.ShowEditTitle();

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        for (; ; ) {
            System.out.print("請輸入單號:");
            int FindId= scanner.nextInt();
            scanner.nextLine();        //怪東西

            SearchSaleRecord SearchTool= new SearchSaleRecord();
            SalesRecord OldsaleRecord;
            SalesRecord NewsaleRecord= new SalesRecord();

            int mResult = SearchTool.FindSaleRecordbyList(xList,String.format("%02d", FindId));

            if (mResult == -1){
                System.out.println(String.format("        ***[ERROR]你輸入的單號 [%s] 不存在!***",String.format("%02d", FindId)));
                continue;
            }else{
                OldsaleRecord = xList.get(mResult);

                for(;;){
                    //System.out.print("請輸入日期(yyyy-MM-dd), 不輸入時默認為今天:");
                    System.out.printf("請輸入新的日期(舊值:%tF):",OldsaleRecord.getDate());

                    String uDate = scanner.nextLine();

                    try{
                        sdf.parse(uDate);
                        //System.out.println(uDate+" is a valid Date");
                        NewsaleRecord.setDate(sdf.parse(uDate));
                        break;
                    }
                    catch(Exception e)
                    {
                        System.out.println("        ***[ERROR]輸入錯誤，格式必須為 yyyy-MM-dd!***");
                    }

                }

                System.out.printf("請輸入新的銷售數量(舊值:%d):",OldsaleRecord.getAmount());
                for(;;){
                    //System.out.print("請輸入銷售數量:");
                    while (!scanner.hasNextInt()) {
                        System.out.println("        ***[ERROR]輸入的不是數值***");
                        scanner.nextLine();
                    }

                    int amount = scanner.nextInt();
                    scanner.nextLine();        //怪東西
                    NewsaleRecord.setAmount(amount);
                    break;
                }

                NewsaleRecord.setId(String.format("%02d", FindId));


                System.out.println("--------------------------");
                System.out.println(String.format("異 動 單 號: %s",String.format("%02d", FindId)));
                System.out.println("狀態      日期        數量");
                System.out.println("--------------------------");
                System.out.println("舊    "+OldsaleRecord.getFormatDate()+"    "+OldsaleRecord.getAmount());
                System.out.println("舊    "+NewsaleRecord.getFormatDate()+"    "+NewsaleRecord.getAmount());


                if (this.AskContinue("是否保存異動的內容(Y/N)?")){
                    xList.set(mResult,NewsaleRecord);
                }

                if (!this.AskContinue("是否要繼續(Y/N)?")){
                    break;
                }
            }
        }


    }

    public void ShowDeleteMessage(ArrayList<SalesRecord> xList) {
        System.out.println("==========================");
        System.out.println("        刪 除 銷 售 紀 錄");
        System.out.println("--------------------------");
        Scanner scanner = new Scanner(System.in);

        //sdf.setLenient(false);
        for (; ; ) {
            System.out.print("請輸入單號:");
            int FindId = scanner.nextInt();
            scanner.nextLine();        //怪東西

            SearchSaleRecord SearchTool = new SearchSaleRecord();
            int mResult = SearchTool.FindSaleRecordbyList(xList, String.format("%02d", FindId));

            if (mResult == -1) {
                System.out.println(String.format("        ***[ERROR]你輸入的單號 [%s] 不存在!***", String.format("%02d", FindId)));
                continue;
            } else {
                SalesRecord TempsaleRecord;
                TempsaleRecord = xList.get(mResult);
                System.out.println("--------------------------");
                System.out.println(String.format("刪 除 單 號: %s",String.format("%02d", FindId)));
                System.out.println("日期    數量");
                System.out.println("--------------------------");
                System.out.println(TempsaleRecord.getFormatDate()+"     "+TempsaleRecord.getAmount());
                if (this.AskContinue("是否刪除指定的單號(Y/N)?")){
                    xList.remove(mResult);
                }

                if (!this.AskContinue("是否要繼續(Y/N)?")){
                    break;
                }

            }
        }

    }
    public int ShowBrowserMessage() {
        this.ShowBrowserMainMenu();

        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String conditionEmpty = scanner.nextLine();
            if (conditionEmpty.equals("")) { //不輸入 不排序直接顯示
                return -1;
            }


//            while (!scanner.hasNextInt()) {
//                System.out.println("        ***[ERROR]輸入錯誤，只能為:[1, 2]***");
//                scanner.nextLine();
//            }

            if (!isInteger(conditionEmpty)){
                System.out.println("        ***[ERROR]輸入錯誤，只能為:[1, 2]***");
                //this.ShowBrowserMainMenu();
                continue;
            }
            int condition = Integer.valueOf(conditionEmpty);
            switch (condition) {
                case 1:
                    System.out.println("==========================");
                    System.out.println("1. 數量由小到大排序");
                    return 1;

                case 2:
                    System.out.println("==========================");
                    System.out.println("2. 數量由大到小排序");
                    return 2;

                default:
                    System.out.println("        ***[ERROR]輸入錯誤，只能為:[1, 2]***");
                    System.out.println("--------------------");
                    this.ShowBrowserMainMenu();

            }
        }
    }

    public boolean ShowInsertMessage(SalesRecord s){

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);

        for(;;){
            System.out.print("請輸入日期(yyyy-MM-dd), 不輸入時默認為今天:");
            String uDate = scanner.nextLine();
            if (uDate.equals("")){    //不輸入
                //SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date current = new Date();
                s.setDate(current);
                break;
            }else{

                try{
                    sdf.parse(uDate);
                    //System.out.println(uDate+" is a valid Date");
                    s.setDate(sdf.parse(uDate));
                    break;
                }
                catch(Exception e)
                {
                    System.out.println("        ***[ERROR]輸入錯誤，格式必須為 yyyy-MM-dd!***");
                }
            }
        }



        for(;;){
            System.out.print("請輸入銷售數量:");
            while (!scanner.hasNextInt()) {
                System.out.println("        ***[ERROR]輸入的不是數值***");
                scanner.nextLine();
            }

            int amount = scanner.nextInt();
            scanner.nextLine();        //怪東西
            s.setAmount(amount);
            break;
        }
        //scanner.close();
        return true;
    }

    public boolean AskContinue(String s){
        Scanner scanner = new Scanner(System.in);
        System.out.print(s);
        String xContinue = scanner.nextLine();
        if (xContinue.equals("Y") || xContinue.equals("y")){
            return true;
        }else{
            return false;
        }
    }


}


