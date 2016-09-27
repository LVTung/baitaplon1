package com.kpt.tunglv.lovecalculator.API;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tung on 2016/09/23.
 */
public class DataLogin implements Parcelable {
    public String fname;
    public String sname;
    public int percentage;
    public String result;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fname);
        dest.writeString(this.sname);
        dest.writeInt(this.percentage);
        dest.writeString(this.result);
    }

    public DataLogin() {
    }

    protected DataLogin(Parcel in) {
        this.fname = in.readString();
        this.sname = in.readString();
        this.percentage = in.readInt();
        this.result = in.readString();
    }

    public static final Parcelable.Creator<DataLogin> CREATOR = new Parcelable.Creator<DataLogin>() {
        @Override
        public DataLogin createFromParcel(Parcel source) {
            return new DataLogin(source);
        }

        @Override
        public DataLogin[] newArray(int size) {
            return new DataLogin[size];
        }
    };
}
