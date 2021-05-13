package com.jithu.tutorialapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ModuleModel implements Parcelable {

    private String module_name;
    private float progress;
    private List<ChapterModel> chapters;

    public ModuleModel(String module_name, float progress, List<ChapterModel> chapters) {
        this.module_name = module_name;
        this.progress = progress;
        this.chapters = chapters;
    }

    protected ModuleModel(Parcel in) {
        module_name = in.readString();
        progress = in.readFloat();
    }

    public static final Creator<ModuleModel> CREATOR = new Creator<ModuleModel>() {
        @Override
        public ModuleModel createFromParcel(Parcel in) {
            return new ModuleModel(in);
        }

        @Override
        public ModuleModel[] newArray(int size) {
            return new ModuleModel[size];
        }
    };

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public List<ChapterModel> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterModel> chapters) {
        this.chapters = chapters;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(module_name);
        parcel.writeFloat(progress);
    }
}
