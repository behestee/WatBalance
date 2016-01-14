package com.cg.watbalance.data;

import org.joda.time.DateTime;

public class ConnectionDetails {
    final String uWaterlooURL = "https://account.watcard.uwaterloo.ca/cgi-bin/OneWeb.exe?";
    private String myIDNum = null;
    private String myPinNum = null;
    private String myBalanceURL;
    final String APIURL = "https://api.uwaterloo.ca/v2/";
    final String APIKey = "?key=907f2381ac84737b6bfe0e41d159fbee";
    final String FoodURL = APIURL + "foodservices/menu.json" + APIKey;

    public ConnectionDetails(String newIDNum, String newPinNum) {
        myIDNum = newIDNum;
        myPinNum = newPinNum;
        myBalanceURL = uWaterlooURL + "acnt_1=" + myIDNum + "&acnt_2=" + myPinNum + "&FINDATAREP=ON&STATUS=STATUS";
    }

    public String getBalanceURL() {
        return myBalanceURL;
    }

    public String getTransactionURL() {
        DateTime myDate = DateTime.now();
        int month = myDate.getMonthOfYear();
        int lastDayOfMonth = myDate.dayOfMonth().getMaximumValue();
        int year = myDate.getYear();

        return uWaterlooURL + "acnt_1=" + myIDNum + "&acnt_2=" + myPinNum + "&DBDATE=" + month + "%2F1%2F" + year + "&DEDATE=" + month + "%2F" + lastDayOfMonth + "%2F" + year + "&PASS=PASS&STATUS=HIST";
    }

    public String getFoodURL(){
        return FoodURL;
    }

    public String getIDString() {
        return "ID# " + myIDNum;
    }
}