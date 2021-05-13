package com.jithu.tutorialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ModuleAdapter.OnModuleClickListen {

    ModuleAdapter moduleAdapter;
    List<ModuleModel> moduleModelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView moduleRV =findViewById(R.id.module_rv);

        moduleAdapter = new ModuleAdapter(moduleModelList,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        moduleRV.setLayoutManager(linearLayoutManager);
        moduleRV.setHasFixedSize(true);
        moduleRV.setAdapter(moduleAdapter);

        getData();

    }

    private void getData() {
        List<ChapterModel> chapters = new ArrayList<>();
        ChapterModel chapterModel = new ChapterModel("c1",R.raw.video1,0);
        chapters.add(chapterModel);
        chapters.add(chapterModel);

        moduleModelList.add(new ModuleModel("Hello",0,chapters));
        moduleModelList.add(new ModuleModel("Hello",0,chapters));
        moduleModelList.add(new ModuleModel("Hello",0,chapters));
        moduleModelList.add(new ModuleModel("Hello",0,chapters));


        moduleAdapter.notifyDataSetChanged();
    }

    @Override
    public void onModuleClick(int position) {
        startActivity(new Intent(this, ChapterListActivity.class)
                .putExtra("module", moduleModelList.get(position))
                .putParcelableArrayListExtra("chapters", (ArrayList<? extends Parcelable>) moduleModelList.get(position).getChapters())
        );
    }
}