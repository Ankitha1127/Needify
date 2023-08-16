package com.example.mad_project;

public class model
{
    String id,name,date,location,phno;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getPhno() {
        return phno;
    }

    public model(String id, String name, String date, String location, String phno)
    {
        this.id= id;
        this.name=name;
        this.date=date;
        this.location=location;
        this.phno=phno;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

}
