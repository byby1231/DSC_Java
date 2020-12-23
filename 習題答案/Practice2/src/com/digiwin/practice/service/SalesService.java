/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.digiwin.practice.service;

import com.digiwin.practice.pojo.SalesRecord;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/**
 *
 * @author user
 */
public class SalesService {
    private List<SalesRecord>  SalesRecords = new ArrayList<>();
    public SalesRecord ExportData;
    public String ResultMessage = "";
    /// 建構式
    public SalesService()
    {
        InitSalesRecords();
    }
    
    private void InitSalesRecords()
    {
        SalesRecords.clear();
        SalesRecords.add(new SalesRecord("1",new Date(),100));
        SalesRecords.add(new SalesRecord("2",new Date(),600));
        SalesRecords.add(new SalesRecord("3",new Date(),200));
        SalesRecords.add(new SalesRecord("4",new Date(),300));
        SalesRecords.add(new SalesRecord("5",new Date(),900));
    }
    
    /// 執行查詢
    public  List<SalesRecord> DoQuery(String ICondition)
    {
        switch(ICondition)
        {
            case "1":
                SortByAmountAsc();
                break;
            case "2":
                SortByAmountDesc();
                break;
            default:
                SortByID();
                break;
        }
        
        return SalesRecords;
    }
    
    // 取得最大ID
    private String GetMAXID()
    {
        String _MAXID = SalesRecords.stream()
        .max(Comparator.comparing(i -> i.id)).get().id;        
        return String.valueOf(Integer.valueOf(_MAXID)+1);
    }    
    
    // 依ID遞增排序
    private void SortByID()
    {
        Collections.sort(SalesRecords,
        new Comparator<SalesRecord>() {
            public int compare(SalesRecord o1, SalesRecord o2) {
                return o1.getid().compareTo(o2.getid());
            }
        });
    }
    
    // 依Amount遞增排序
    private void SortByAmountAsc()
    {
        Collections.sort(SalesRecords,
        new Comparator<SalesRecord>() {
            public int compare(SalesRecord o1, SalesRecord o2) {
                return o1.getamount() - o2.getamount() ;
            }
        });
    }
    
    // 依Amount遞減排序
    private void SortByAmountDesc()
    {
        Collections.sort(SalesRecords,
        new Comparator<SalesRecord>() {
            public int compare(SalesRecord o1, SalesRecord o2) {
                return o2.getamount() - o1.getamount() ;
            }
        });
    }
    
    /// 執行新增
    public boolean DoInsert(Date IDate, int IAmount)
    {
        try
        {
           String MAXID =  GetMAXID();
           SalesRecords.add(new SalesRecord(MAXID,IDate,IAmount));
           ResultMessage = "新增成功, 單號為:"+ MAXID;
           return true;
        } catch (Exception ex)
        {
            ResultMessage = "資料新增失敗";
            return false;
        }
    }

    /// 執行修改
    public boolean DoUpdate(String IID,Date IDate, int IAmount)
    {        
        try
        {
            SalesRecord _One = SalesRecords.stream().filter(x-> IID.equals(x.id)).findFirst().get();
            _One.date = IDate;
            _One.amount = IAmount;
            ResultMessage = "保存成功!";
             return true;
        } catch (Exception ex)
        {
            ResultMessage = "資料更新失敗";
            return false;
        }
    }
    
    /// 執行刪除
    public boolean DoDelete(String IID)
    {
        try
        {
            Iterator<SalesRecord> itr = SalesRecords.iterator();
            while(itr.hasNext())
            {
                SalesRecord _One = itr.next();
                if(IID.equals(_One.id))
                {
                    itr.remove();
                    ResultMessage = "刪除成功!";
                    return true;
                }
            }
            ResultMessage = "資料刪除失敗";
            return false;
        } catch (Exception ex)
        {
            ResultMessage = "資料刪除失敗";
            return false;
        }
    }
    
    public boolean DoQueryByID(String IID)
    {
        if(SalesRecords.stream().filter(x-> IID.equals(x.id)).findFirst().isPresent())
        {
            try
            {
                ExportData = SalesRecords.stream().filter(x-> IID.equals(x.id)).findFirst().get().clone();
                return true;
            }
            catch(Exception e)
            {
                ExportData = null;
                return false;
            }
        }
        else
        {
            ExportData = null;
            return false;
        }
            
    }
}
