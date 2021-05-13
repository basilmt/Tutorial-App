package com.jithu.tutorialapp;

import android.os.Parcel;
import android.os.Parcelable;

public class ChapterModel implements Parcelable {

    private String chapter_name;
    private int resource_id;
    private float progress;

    public ChapterModel(String chapter_name, int resource_id, float progress) {
        this.chapter_name = chapter_name;
        this.resource_id = resource_id;
        this.progress = progress;
    }

    protected ChapterModel(Parcel in) {
        chapter_name = in.readString();
        resource_id = in.readInt();
        progress = in.readFloat();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(chapter_name);
        dest.writeInt(resource_id);
        dest.writeFloat(progress);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ChapterModel> CREATOR = new Creator<ChapterModel>() {
        @Override
        public ChapterModel createFromParcel(Parcel in) {
            return new ChapterModel(in);
        }

        @Override
        public ChapterModel[] newArray(int size) {
            return new ChapterModel[size];
        }
    };

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

}
