/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.digiwin.practice.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author user
 */
public class SalesRecord  implements Cloneable
{
    @Override
    public SalesRecord clone() throws CloneNotSupportedException 
    {
        return (SalesRecord)super.clone();
    }
    public SalesRecord(){}
    public SalesRecord(String IID,Date IDate, int IAmount)
    {
        id = IID;
        date=IDate;
        amount = IAmount;
    }
    public String id;
    public Date date;
    public int amount;
    
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
