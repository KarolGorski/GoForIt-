package alisprojects.goforitonnd.HowToServiceThatStupidAzure.Tables;

/**
 * Created by Karol on 2017-07-06.
 */

public class User {
    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    @com.google.gson.annotations.SerializedName("name")
    private String mName;

    @com.google.gson.annotations.SerializedName("surname")
    private String mSurname;

    @com.google.gson.annotations.SerializedName("email")
    private String mEmail;

    @com.google.gson.annotations.SerializedName("password")
    private String mPassword;

    @com.google.gson.annotations.SerializedName("level")
    private String mLevel;

    @com.google.gson.annotations.SerializedName("experience")
    private int mExperience;

    @com.google.gson.annotations.SerializedName("dodaysform")
    private int mTodaysForm;

    @com.google.gson.annotations.SerializedName("complete")
    private boolean mComplete;

    public User() {

    }

    @Override
    public String toString() {
        return getName()+getSurname();
    }

    public User(String name, String id) {
        this.setName(name);
        this.setId(id);
    }

    public String getName() {return mName;}

    public final void setName(String name) {mName = name;}

    public String getSurname() {return mSurname;}

    public final void setSurname(String name) {mSurname = name;}

    public String getEmail() {
        return mEmail;
    }

    public final void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {return mPassword;}

    public void setPassword(String mPassword) {this.mPassword = mPassword;}

    public String getLevel() {return mLevel;}

    public void setLevel(String mLevel) {this.mLevel = mLevel;}

    public int getExperience() {return mExperience;}

    public void setExperience(int mExperience) {this.mExperience = mExperience;}

    public int getTodaysForm() {return mTodaysForm;}

    public void setTodaysForm(int mTodaysForm) {this.mTodaysForm = mTodaysForm;}

    public String getId() {
        return mId;
    }

    public final void setId(String id) {
        mId = id;
    }

    public boolean isComplete() {
        return mComplete;
    }

    public void setComplete(boolean complete) {
        mComplete = complete;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof User && ((User) o).mId == mId;
    }
}