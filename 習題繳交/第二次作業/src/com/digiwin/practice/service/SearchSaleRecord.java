package com.digiwin.practice.service;

import com.digiwin.practice.pojo.SalesRecord;

import java.util.ArrayList;

public class SearchSaleRecord {

    public SearchSaleRecord() {
    }

    public int FindSaleRecordbyList(ArrayList<SalesRecord> xList,String xID){
        boolean IsFind = false;
        int i;
        i = -1;
        for (SalesRecord salesRecord : xList) {
            i++;
            if (salesRecord.getId().equals(xID)) {
                IsFind = true;
                break;
            }
        }
        if(!IsFind) {i = -1;}
        return i;
    }
}
