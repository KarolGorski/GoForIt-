package alisprojects.goforitonnd.HowToServiceThatStupidAzure.Tables;

/**
 * Created by Karol on 2017-07-06.
 */

public class User {

    String[] Forms={"Ehh.. It can only get better...",
            "Mhmm...Do or do not. There is no trying!",
            "Meh..Not as bad as it could be.",
            "Not bad!",
            "Nice! You get better and better!",
            "Wow! Almost the best possible form!",
            "Ohh.. We have a badass here"};

    static private int Id=0;
    private String Name;
    private String Email;
    private int Level;
    private int Experience;
    private String  TodaysForm;
    private int FormCounter;

    public User(String name, String Email) {
        Id++;
        this.Name=name;
        this.Email=Email;
        Level=1;
        Experience=0;
        FormCounter=3;
        TodaysForm=Forms[FormCounter];

    }

    private void resetForm(){
        TodaysForm=Forms[FormCounter];
    }


    @Override
    public String toString(){

        return Name;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public String getTodaysForm() {
        return TodaysForm;
    }

    public void increaseTodaysForm() {
        if(FormCounter<6)
            FormCounter++;
        resetForm();

    }
    public void decreaseTodaysForm(){
        if(FormCounter>0)
            FormCounter--;
        resetForm();


    }
}