package alisprojects.goforitonnd.HowToServiceThatStupidAzure.Tables;

/**
 * Created by Karol on 2017-07-06.
 */

import java.util.Date;

public class Task {
    static public int id=0;
    public String text;
    public String info;
    public Date startDate;

    public String difficulty;
    public boolean complete;

    public Task(){

    }
    public Task(String text, String info, Date sd,String difficulty){
        id++;
        this.info=info;
        this.text=text;
        this.startDate=sd;
        this.difficulty=difficulty;
        complete=false;
    }
}