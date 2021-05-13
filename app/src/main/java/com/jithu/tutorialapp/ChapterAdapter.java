package com.jithu.tutorialapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {

    List<ChapterModel> chapterModelList;
    OnChapterClickListen onChapterClickListen;

    public ChapterAdapter(List<ChapterModel> chapterModelList, OnChapterClickListen onChapterClickListen) {
        this.chapterModelList = chapterModelList;
        this.onChapterClickListen = onChapterClickListen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.chapter_single_item, parent, false);
        return new ViewHolder(view, onChapterClickListen);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i("TAGggg", "onBindViewHolder: " + chapterModelList.size());
        holder.chapter_name.setText(chapterModelList.get(position).getChapter_name());

    }

    @Override
    public int getItemCount() {
        return chapterModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnChapterClickListen onClickListen;
        TextView chapter_name;

        public ViewHolder(@NonNull View itemView, OnChapterClickListen onChapterClickListen) {
            super(itemView);

            chapter_name = itemView.findViewById(R.id.chapter_name);

            this.onClickListen = onChapterClickListen;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onClickListen.onChapterClick(getAdapterPosition());
        }
    }

    public interface OnChapterClickListen {
        void onChapterClick(int position);
    }

}
