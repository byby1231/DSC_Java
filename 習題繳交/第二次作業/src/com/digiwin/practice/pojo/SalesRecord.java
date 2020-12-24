package com.digiwin.practice.pojo;


import java.text.SimpleDateFormat;
import java.util.Date;



public class SalesRecord {

    private String id;
    private Date date;
    private int amount;

    public SalesRecord(){}
    public SalesRecord(String IID,Date IDate, int IAmount)
    {
        id = IID;
        date=IDate;
        amount = IAmount;
    }

    public String getid()
    {
        return this.id;
    }
    public int getamount()
    {
        return this.amount;
    }
    public String GetPrint()
    {
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        return this.id+"      "+Format.format(this.date) +"      "+this.amount;
    }

}
