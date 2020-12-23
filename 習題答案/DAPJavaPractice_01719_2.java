/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.digiwin.practice;

import static com.digiwin.practice.DAPJavaPractice_01719_2._SalesService;
import com.digiwin.practice.pojo.SalesRecord;
import com.digiwin.practice.service.SalesService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class DAPJavaPractice_01719_2 {
    public static SalesService _SalesService = new SalesService();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        String Action = "";
        do
        {
            WelcomeDialog_Main();
            Action = FunctionDialog_Main(scan);
             System.out.println(Action);
        }while(!("9".equals(Action)) && FunctionDialog_SystemContuin(scan));
        System.out.println("操作結束。");
    }
    
    // 系統提示訊息
    private static void WelcomeDialog_Main()
    {
        System.out.println("***** DAP Java 練習二 *****");
        System.out.println("==========================");
        System.out.println("銷 售 紀 錄 管 理 系 統");
        System.out.println("--------------------------");
        System.out.println("	1.查 詢");
        System.out.println("	2.新 增");
        System.out.println("	3.修 改");
        System.out.println("	4.刪 除");
        System.out.println("");
        System.out.println("	9.退 出");
        System.out.println("==========================");
    }
    
    // 功能選擇對話
    private static String FunctionDialog_Main(Scanner scan)
    {
        boolean _Pass = false;
        String input;
        do{
            System.out.print("請輸入功能碼:");
            input = scan.next();
            switch(input)
            {
                case "1":
                    do
                    {
                        WelcomeDialog_Query();
                        FunctionDialog_Query(scan);
                    }while(FunctionDialog_Contuin(scan));
                    _Pass = true;
                    break;
                case "2":
                    do
                    {
                        WelcomeDialog_Insert();
                        FunctionDialog_Insert(scan);
                    }while(FunctionDialog_Contuin(scan));
                    _Pass = true;
                    break;
                case "3":
                    do
                    {
                        WelcomeDialog_Update();
                        FunctionDialog_Update(scan);
                    }while(FunctionDialog_Contuin(scan));
                    _Pass = true;
                    break;
                case "4":
                    do
                    {
                        WelcomeDialog_Delete();
                        FunctionDialog_Delete(scan);
                    }while(FunctionDialog_Contuin(scan));
                    _Pass = true;
                case "9":
                    _Pass = true;
                    break;
                default:
                    System.out.println("        ***[ERROR]輸入錯誤，只能為:[1, 2, 3, 4, 9]***");
                    _Pass = false;
            }
        }while(!_Pass);
        return input;
    }
    
    // 是否要回到功能選單
    private static boolean FunctionDialog_SystemContuin(Scanner scan)
     {
        //if("9".equals(IAction)){ return false;}
        boolean _Pass = false;
        String input;
        do{
            System.out.println("是否要回到功能選單(Y/N)?");
            input = scan.next();
            switch(input)
            {
                case "Y":
                case "y":
                    return true;
                case "N":
                case "n":
                   return false;
                default:
                    _Pass = false;
            }
        }while(!_Pass);
         return false;
    }
    // 詢問是否繼續
    private static boolean FunctionDialog_Contuin(Scanner scan)
    {
        boolean _Pass = false;
        String input;
        do{
            System.out.println("是否要繼續(Y/N)?");
            input = scan.next();
            switch(input)
            {
                case "Y":
                case "y":
                    return true;
                case "N":
                case "n":
                   return false;
                default:
                    _Pass = false;
            }
        }while(!_Pass);
         return false;
    }
    
    // 查詢頁提示訊息
    private static void  WelcomeDialog_Query()
    {
        System.out.println("==========================");
        System.out.println("        銷 售 紀 錄 列 表");
        System.out.println("        1. 數量由小到大排序");
        System.out.println("        2. 數量由大到小排序");
        System.out.println("--------------------------");
    }
    
    // 查詢頁功能選擇對話
    private static String FunctionDialog_Query(Scanner scan)
    {
        boolean _Pass = false;
        String input;
        do{
            System.out.print("請輸入排序方式, 不輸入時不排序:");
            input = scan.next();
            switch(input)
            {
                case "":
                case "1":
                case "2":
                    System.out.println("--------------------------");
                    System.out.println("編號    日期    金額");
                    System.out.println("--------------------------");
                    
                    for(SalesRecord _one:_SalesService.DoQuery(input))
                    {
                        System.out.println( _one.GetPrint());
                    }
                    _Pass = true;
                    break;
                default:
                    System.out.println("        ***[ERROR]輸入錯誤，只能為:[1, 2]***");
                    _Pass = false;
            }
        }while(!_Pass);
        return input;
    }
    
    private static void  WelcomeDialog_Insert()
    {
        System.out.println("==========================");
        System.out.println("        新 增 銷 售 紀 錄");
        System.out.println("--------------------------");
    }
    
    private static String FunctionDialog_Insert(Scanner scan)
    {
        boolean _Pass = false;
        String _Input = "";
        SimpleDateFormat _DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date _Date = new Date();;
        int _Amount = 0;
        do{
            System.out.println("請輸入日期(yyyy-MM-dd), 不輸入時默認為今天:");
            _Input = scan.next();
            try
            {
                if(!("".equals(_Input)))                
                {
                    _Date = _DateFormat.parse(_Input);
                }
                _Pass = true;
            }
            catch(Exception e)
            {
                System.out.println("        ***[ERROR]輸入錯誤，格式必須為 yyyy-MM-dd!***");
                _Pass = false;
            }
            
            System.out.println("請輸入銷售數量:");
            _Input = scan.next();
            try
            {
                _Amount = Integer.valueOf(_Input);
                _Pass = true;
            }
            catch(Exception e)
            {
                System.out.println("        ***[ERROR]輸入的不是數值***");
                _Pass = false;
            }
        }while(!_Pass);
        _SalesService.DoInsert(_Date, _Amount);
        System.out.println(_SalesService.ResultMessage);
        
        return "";
    }
    
    private static void  WelcomeDialog_Update()
    {
        System.out.println("==========================");
        System.out.println("        編 輯 銷 售 紀 錄");
        System.out.println("--------------------------");
    }
    
    private static String FunctionDialog_Update(Scanner scan)
    {
        boolean _Pass = false;
        String _Input = "";
        SimpleDateFormat _DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String _ID = "";
        Date _Date = new Date();;
        int _Amount = 0;
        do
        {
             System.out.println("請輸入單號:");
            _Input = scan.next();
             if(!_SalesService.DoQueryByID(_Input))
             {
                System.out.println("        ***[ERROR]你輸入的單號 ["+_Input+"] 不存在!***");
                _Pass = false;
             }
             else
             {
                 _Pass = true;
             }    
        }while(!_Pass);
         _Pass = false;
         _ID = _SalesService.ExportData.id;
        do{
            System.out.println("請輸入新的日期(舊值:"+_DateFormat.format(_SalesService.ExportData.date)+"):");
            _Input = scan.next();
            try
            {
                if(!("".equals(_Input)))                
                {
                    _Date = _DateFormat.parse(_Input);
                }
                _Pass = true;
            }
            catch(Exception e)
            {
                System.out.println("        ***[ERROR]輸入錯誤，格式必須為 yyyy-MM-dd!***");
                _Pass = false;
            }
        }while(!_Pass);
         _Pass = false;
         do
         {
            System.out.println("請輸入新的銷售數量(舊值:"+_SalesService.ExportData.amount+"):");
            _Input = scan.next();
            try
            {
                _Amount = Integer.valueOf(_Input);
                _Pass = true;
            }
            catch(Exception e)
            {
                System.out.println("        ***[ERROR]輸入的不是數值***");
                _Pass = false;
            }
        }while(!_Pass);
         
         System.out.println("--------------------------");
         System.out.println("異 動 單 號:" + _ID);
         System.out.println("狀態    日期    數量");
         System.out.println("--------------------------");
         System.out.println("舊      "+_DateFormat.format(_SalesService.ExportData.date)+"      "+_SalesService.ExportData.amount);
         System.out.println("新      "+_DateFormat.format(_Date)+"      "+_Amount);
         
         do{
            System.out.println("是否保存異動的內容(Y/N)?");
            _Input = scan.next();
            switch(_Input)
            {
                case "Y":
                case "y":                    
                    _SalesService.DoUpdate(_ID, _Date, _Amount);
                    System.out.println(_SalesService.ResultMessage);
                    _Pass = true;
                    break;
                case "N":
                case "n":
                   _Pass = true;
                    break;
                default:
                    _Pass = false;
            }
        }while(!_Pass);
        return "";
    }
    
    private static void  WelcomeDialog_Delete()
    {
        System.out.println("==========================");
        System.out.println("        刪 除 銷 售 紀 錄");
        System.out.println("--------------------------");
    }
    
    private static String FunctionDialog_Delete(Scanner scan)
    {
        boolean _Pass = false;
        String _Input = "";
        String _ID = "";
        SimpleDateFormat _DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        do
        {
             System.out.println("請輸入單號:");
            _Input = scan.next();
             if(!_SalesService.DoQueryByID(_Input))
             {
                System.out.println("        ***[ERROR]你輸入的單號 ["+_Input+"] 不存在!***");
                _Pass = false;
             }
             else
             {
                 _Pass = true;
             }    
        }while(!_Pass);
         _ID = _Input;

         System.out.println("--------------------------");
         System.out.println("刪 除 單 號:" + _Input);
         System.out.println("日期    數量");
         System.out.println("--------------------------");
         System.out.println(_DateFormat.format(_SalesService.ExportData.date)+"      "+_SalesService.ExportData.amount);

         _Pass = false; 
         do{
            System.out.println("是否刪除指定的單號(Y/N)?");
            _Input = scan.next();
            switch(_Input)
            {
                case "Y":
                case "y":                    
                    _SalesService.DoDelete(_ID);
                    System.out.println(_SalesService.ResultMessage);
                    _Pass = true;
                    break;
                case "N":
                case "n":
                   _Pass = true;
                    break;
                default:
                    _Pass = false;
            }
        }while(!_Pass);
        return "";
    }
}
