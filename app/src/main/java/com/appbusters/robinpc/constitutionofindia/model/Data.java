package com.appbusters.robinpc.constitutionofindia.model;

public class Data {

    public String Title;
    public String subTitle;
    public String Desc;

    public Data(String Title, String subTitle, String Desc){
        this.Title = Title;
        this.subTitle = subTitle;
        this.Desc = Desc;
    }


    //getters and setters

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }
}
