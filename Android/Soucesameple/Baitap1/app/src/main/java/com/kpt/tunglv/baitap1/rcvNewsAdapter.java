package com.kpt.tunglv.baitap1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Tung on 2016/08/08.
 */
public class rcvNewsAdapter extends RecyclerView.Adapter<ViewHolderNews> {
    List<line_news> line_newsBeanlist;
    //buoi7
//    Callback callback;

//    public void setOnREcyclerViewItemClick(Callback callback) {
//        this.callback = callback;
//    }


    public rcvNewsAdapter(List<line_news> line_newsBeanlist) {
        this.line_newsBeanlist = line_newsBeanlist;
    }

    @Override
    public ViewHolderNews onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new ViewHolderNews(layoutInflater.inflate(R.layout.line_news, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolderNews holder, int position) {
        holder.bind(line_newsBeanlist.get(position));


    }

    @Override
    public int getItemCount() {
        return line_newsBeanlist.size();
    }
}


