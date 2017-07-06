package alisprojects.goforitonnd.HowToServiceThatStupidAzure.Tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

/**
 * Created by Karol on 2017-07-06.
 */

public class User {

    public HashMap<String,String> hmap= new HashMap<String, String>();

    public String Name;
    public String Email;
    public int Level;
    public int Experience;
    public String  TodaysForm;
    public String FormCounter;

    public User(){

    }

    public User(String name, String Email) {
        hmap.put("0","Ehh.. It can only get better...");
        hmap.put("1","Mhmm...Do or do not. There is no trying!");
        hmap.put("2","Meh..Not as bad as it could be.");
        hmap.put("3","Not bad!");
        hmap.put("4","Nice! You get better and better!");
        hmap.put("5","Wow! Almost the best possible form!");
        hmap.put("6","Ohh.. We have a badass here! :O");




        this.Name=name;
        this.Email=Email;
        Level=1;
        Experience=0;
        FormCounter="2";
        TodaysForm= hmap.get(FormCounter);

    }

    private void resetForm(){
        TodaysForm= hmap.get(FormCounter);
    }


    @Override
    public String toString(){

        return Email;
    }

    public void increaseTodaysForm() {
    int a=Integer.parseInt(TodaysForm);
        if(a<6)
            a++;
        TodaysForm=Integer.toString(a);
        resetForm();

    }
    public void decreaseTodaysForm(){
        int a=Integer.parseInt(TodaysForm);
        if(a>0)
            a--;
        TodaysForm=Integer.toString(a);
        resetForm();


    }
}