package com.digiwin.practice.pojo;


import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;



public class SalesRecord {

    private String id;
    private Date date;
    private int amount;

    public String getId() {
        return id;
    }

    public  int GetIdMax(){
        return Integer.valueOf(id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public SalesRecord(){}
    public SalesRecord(String IID,Date IDate, int IAmount)
    {
        id = IID;
        date=IDate;
        amount = IAmount;
    }
    @Override
    public String toString() {
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        return this.id+"      "+Format.format(this.date) +"      "+this.amount;
    }
    public String GetPrint()
    {
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        return this.id+"      "+Format.format(this.date) +"      "+this.amount;
    }

}

