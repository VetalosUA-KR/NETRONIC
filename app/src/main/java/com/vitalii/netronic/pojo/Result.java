package com.vitalii.netronic.pojo;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable
{

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("id")
    @Expose
    private Id id;
    @SerializedName("login")
    @Expose
    private Login login;
    @SerializedName("dob")
    @Expose
    private Dob dob;
    @SerializedName("picture")
    @Expose
    private Picture picture;
    public final static Creator<Result> CREATOR = new Creator<Result>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Result createFromParcel(android.os.Parcel in) {
            return new Result(in);
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
            ;

    protected Result(android.os.Parcel in) {
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((Name) in.readValue((Name.class.getClassLoader())));
        this.picture = ((Picture) in.readValue((Picture.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.login = ((Login) in.readValue((Login.class.getClassLoader())));
        this.dob = ((Dob) in.readValue((Dob.class.getClassLoader())));
        this.id = ((Id) in.readValue((Id.class.getClassLoader())));

    }

    public Result() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }


    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(gender);
        dest.writeValue(name);
        dest.writeValue(picture);
        dest.writeValue(email);
        dest.writeValue(login);
        dest.writeValue(dob);
        dest.writeValue(id);

    }

    public int describeContents() {
        return 0;
    }

}
