package com.vitalii.netronic.pojo;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dob implements Parcelable
{

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("age")
    @Expose
    private Integer age;
    public final static Creator<Dob> CREATOR = new Creator<Dob>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Dob createFromParcel(android.os.Parcel in) {
            return new Dob(in);
        }

        public Dob[] newArray(int size) {
            return (new Dob[size]);
        }

    }
            ;

    protected Dob(android.os.Parcel in) {
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.age = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Dob() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeValue(age);
    }

    public int describeContents() {
        return 0;
    }

}