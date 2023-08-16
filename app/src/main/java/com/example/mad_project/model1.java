package com.example.mad_project;

public class model1
{
    String hid,hname,hdate,hlocation,hphno,htype;

    public String getHidId() {
        return hid;
    }

    public String getHName() {
        return hname;
    }

    public String getHDate() {
        return hdate;
    }

    public String getHLocation() {
        return hlocation;
    }

    public String getHPhno() {
        return hphno;
    }

    public String getHtype() {
        return htype;
    }



    public model1(String id, String name, String date, String location, String phno,String type)
    {
        this.hid= id;
        this.hname=name;
        this.hdate=date;
        this.hlocation=location;
        this.hphno=phno;
        this.htype=type;
    }

    public void setHId(String id) {
        this.hid = id;
    }

    public void setHName(String name) {
        this.hname = name;
    }

    public void setHdateDate(String date) {
        this.hdate = date;
    }

    public void setHlocationLocation(String location) {
        this.hlocation = location;
    }

    public void setHphno(String phno) {
        this.hphno = phno;
    }

    public void setHtype(String type) {this.htype = type;
    }


}
