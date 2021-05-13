package com.jithu.tutorialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChapterListActivity extends AppCompatActivity implements ChapterAdapter.OnChapterClickListen {

    ModuleModel moduleModel;
    ChapterAdapter chapterAdapter;
    List<ChapterModel> chapterModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_list);

        moduleModel= getIntent().getExtras().getParcelable("module");
        chapterModelList = getIntent().getExtras().getParcelableArrayList("chapters");

        RecyclerView chapterRV =findViewById(R.id.chapter_rv);
        chapterAdapter = new ChapterAdapter(chapterModelList,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        chapterRV.setLayoutManager(linearLayoutManager);
        chapterRV.setHasFixedSize(true);
        chapterRV.setAdapter(chapterAdapter);

    }

    @Override
    public void onChapterClick(int position) {

        int id = chapterModelList.get(position).getResource_id();
        startActivity(new Intent(this,VideoActivity.class)
                .putExtra("resource_id",id)
        );


    }
}