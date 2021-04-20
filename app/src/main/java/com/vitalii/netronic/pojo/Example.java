package com.vitalii.netronic.pojo;

import java.util.List;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example implements Parcelable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("info")
    @Expose
    private Info info;
    public final static Creator<Example> CREATOR = new Creator<Example>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Example createFromParcel(android.os.Parcel in) {
            return new Example(in);
        }

        public Example[] newArray(int size) {
            return (new Example[size]);
        }

    }
            ;

    protected Example(android.os.Parcel in) {
        in.readList(this.results, (Result.class.getClassLoader()));
        this.info = ((Info) in.readValue((Info.class.getClassLoader())));
    }

    public Example() {
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(info);
    }

    public int describeContents() {
        return 0;
    }

}
