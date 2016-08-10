package com.kpt.tunglv.baitap1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Tung on 2016/08/07.
 */
public class ViewHolderNews extends RecyclerView.ViewHolder {
    ImageView imvPhoto;
    TextView txtTitle;
    TextView txtContent;
    TextView txtName;
//    Callback callback;

//    public void setOnRecyclerViewItemClick(Callback callback) {
//        this.callback = callback;
//    }


    public ViewHolderNews(View view) {
        super(view);
        imvPhoto = (ImageView) view.findViewById(R.id.imvLineMenu);
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtContent = (TextView) view.findViewById(R.id.txtDescription);
        txtName = (TextView) view.findViewById(R.id.txtName);

    }

    public void bind(line_news line_newsBean) {
        txtTitle.setText(line_newsBean.title);
        txtContent.setText(line_newsBean.description);
        txtName.setText(line_newsBean.name);
        Glide.with(itemView.getContext()).load(line_newsBean.imageUrl).into(imvPhoto);
    }


//    @Override
//    public void onClick(View view) {
//        if (callback!=null){
//            callback.onClick(view, getAdapterPosition());
//        }
//    }
}
