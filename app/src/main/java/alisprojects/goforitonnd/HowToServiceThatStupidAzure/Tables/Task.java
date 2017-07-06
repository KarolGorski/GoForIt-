package alisprojects.goforitonnd.HowToServiceThatStupidAzure.Tables;

/**
 * Created by Karol on 2017-07-06.
 */

import java.util.Date;

public class Task {

    @com.google.gson.annotations.SerializedName("text")
    private String mText;

    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    @com.google.gson.annotations.SerializedName("complete")
    private boolean mComplete;

    @com.google.gson.annotations.SerializedName("user_id")
    private String mUser_ID;

    @com.google.gson.annotations.SerializedName("Hardness")
    private String mHardness;

    @com.google.gson.annotations.SerializedName("StartTime")
    private Date mStartTime;

    @com.google.gson.annotations.SerializedName("EndTime")
    private Date mEndTime;

    public Task() {

    }

    @Override
    public String toString() {
        return getText();
    }

    public Task(String text, String id) {
        this.setText(text);
        this.setId(id);
        this.setUserID(id);
    }

    //text
    public String getText() {
        return mText;
    }

    public final void setText(String text) {
        mText = text;
    }

    //id
    public String getId() {return mId;}

    public final void setId(String id) {mId = id;}

    //userID
    public String getUserID() {return mUser_ID;}

    public final void setUserID(String id) {mUser_ID=id;}

    //Hardness
    public String getHardness() {return mHardness;}

    public final void setHardness(String hd) {mHardness=hd;}

    //DATES
    public Date getStartTime() {return mStartTime;}

    public final void setStartTime(Date st) {mStartTime=st;}

    public Date getEndTime() {return mEndTime;}

    public final void setEndTime(Date et) {mEndTime=et;}

    //completion
    public boolean isComplete() {
        return mComplete;
    }

    public void setComplete(boolean complete) {
        mComplete = complete;
    }


    @Override
    public boolean equals(Object o) {
        return o instanceof Task && ((Task) o).mId == mId;
    }
}