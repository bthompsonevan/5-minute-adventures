package com.example.a5_minute_adventures;

public class AdventureItem {

    private String textBox = null;
    private String yes = null;
    private String no = null;
    private String choiceYes = null;
    private String choiceNo = null;
    private Integer locationIdX = null;
    private Integer locationIdY = null;


    //Getters / Setters for textBox
    public void setTextBox(String textBox){
        this.textBox = textBox;
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

    //Getters / Setters for choiceYes
    public void setChoiceYes(String choiceYes){
        this.choiceYes = choiceYes;
    }
    public String getChoiceYes() { return choiceYes; }

    //Getters / Setters for choiceNo
    public void setChoiceNo(String choiceNo){
        this.choiceNo = choiceNo;
    }
    public String getChoiceNo() { return choiceNo; }


}
