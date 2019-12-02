package com.example.a5_minute_adventures;

public class AdventureItem {

    private String textBox = null;
    private String yes = null;
    private String no = null;
    private Integer locationIdX = null;
    private Integer locationIdY = null;

    //Getters / Setters for textBox
    public void setTextBox(String text){
        this.textBox = text;
    }
    public String getTextBox(){
        return textBox;
    }

    //Getters / Setters for yes
    public void setYes(String yesAnswer){
        this.yes = yesAnswer;
    }
    public String getYes(){
        return yes;
    }

    //Getters / Setters for no
    public void setNo(String noAnswer){
        this.no = noAnswer;
    }
    public String getNo(){
        return no;
    }

    //Getters / Setters for LocationIdX
    public void setLocationIdX(Integer xCoord){
        this.locationIdX = xCoord;
    }
    public Integer getLocationIdX(){
        return locationIdX;
    }

    //Getters / Setters for LocationIdY
    public void setLocationIdY(Integer yCoord){
        this.locationIdY = yCoord;
    }
    public Integer getLocationIdY(){
        return locationIdY;
    }


}