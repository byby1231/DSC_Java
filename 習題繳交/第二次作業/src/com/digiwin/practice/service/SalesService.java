package com.digiwin.practice.service;

import com.digiwin.practice.pojo.SaleRecordSort;
import com.digiwin.practice.pojo.SalesRecord;
import com.digiwin.practice.ui.DisplayUI;

import java.util.*;

public class SalesService{
    private final ArrayList<SalesRecord> Salelist = new ArrayList<SalesRecord>();
    private DisplayUI displayUI;

    public SalesService() {
        Salelist.add(new SalesRecord("01",new Date(),10));
        Salelist.add(new SalesRecord("03",new Date(),30));
        Salelist.add(new SalesRecord("02",new Date(),20));
        Salelist.add(new SalesRecord("04",new Date(),40));
        displayUI = new DisplayUI();
    }

    public void InsertRecord(String xId, Date xDate,Integer xAmount){

//        SalesRecord salesRecord = new SalesRecord(xId,xDate,xAmount);
        for(;;) {                   //預設連續新增
            SalesRecord salesRecord = new SalesRecord();
            if (displayUI.ShowInsertMessage(salesRecord)){
                SalesRecord salesRecordMax = Collections.max(Salelist, Comparator.comparing(s -> s.GetIdMax()));
                salesRecord.setId(String.format("%02d", salesRecordMax.GetIdMax() + 1));
                Salelist.add(salesRecord);
                System.out.println("新增成功, 單號為: "+salesRecord.getId());
            }
            if (!displayUI.AskContinue("是否要繼續(Y/N)?")) {
                break;
            }
        }
//        System.out.println("Length"+Salelist.size());
//        Salelist.remove(2);
//        System.out.println("Length"+Salelist.size());
    }

    public void ShowList(){
        for(;;) {
            int OrderCondition = displayUI.ShowBrowserMessage();

            ArrayList tempSalelist = (ArrayList) Salelist.clone();

            if (OrderCondition == 1) {    //數量由小到大排序
                Collections.sort(tempSalelist, new SaleRecordSort());
                displayUI.ShowBrowserTitle();
                for (int i = 0; i < tempSalelist.size(); i++) {
                    System.out.println(tempSalelist.get(i));
                }

            } else if (OrderCondition == 2) { //數量由大到小排序
                Collections.sort(tempSalelist, new SaleRecordSort());
                Collections.reverse(tempSalelist);
                displayUI.ShowBrowserTitle();
                for (int i = 0; i < tempSalelist.size(); i++) {
                    System.out.println(tempSalelist.get(i));
                }
            } else if (OrderCondition == -1) {    //不排序直接顯示

                for (int i = 0; i < tempSalelist.size(); i++) {
                    System.out.println(tempSalelist.get(i));
                }
                ;
            }
            if (!displayUI.AskContinue("是否要繼續(Y/N)?")){
                break;
            }
        }


    }
}
