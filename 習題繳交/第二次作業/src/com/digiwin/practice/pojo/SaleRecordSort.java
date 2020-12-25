package com.digiwin.practice.pojo;


import java.util.Comparator;

public class SaleRecordSort implements Comparator<SalesRecord>
{
    public SaleRecordSort() {
    }

    //以數量升序排列
    public int compare(SalesRecord a, SalesRecord b)
    {
        return Integer.valueOf(a.getAmount()) - Integer.valueOf(b.getAmount());
    }


}
