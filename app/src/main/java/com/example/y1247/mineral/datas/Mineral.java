package com.example.y1247.mineral.datas;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by y1247 on 2017/3/25.
 */

public class Mineral implements Parcelable {

    public static final int HTML = 1;
    public static final int VIDEO = 0;


    private String name;
    private String id;
    private int picUrl;
    private String video_storage;
    private int type;

    protected Mineral(Parcel in) {
        name = in.readString();
        id = in.readString();
        picUrl = in.readInt();
        video_storage = in.readString();
        type = in.readInt();
    }

    public static final Creator<Mineral> CREATOR = new Creator<Mineral>() {
        @Override
        public Mineral createFromParcel(Parcel in) {
            return new Mineral(in);
        }

        @Override
        public Mineral[] newArray(int size) {
            return new Mineral[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {


        dest.writeString(name);
        dest.writeString(id);
        dest.writeInt(picUrl);
        dest.writeString(video_storage);
        dest.writeInt(type);
    }


    public Mineral(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Mineral(String name, String id, int picUrl, String video_storage, int type) {
        this.name = name;
        this.id = id;
        this.picUrl = picUrl;
        this.video_storage = video_storage;
        this.type = type;
    }

    public int getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(int picUrl) {
        this.picUrl = picUrl;
    }

    public String getVideo_storage() {
        return video_storage;
    }

    public void setVideo_storage(String video_storage) {
        this.video_storage = video_storage;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
