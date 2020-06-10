package com.example.taskapp.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapp.R;
import com.example.taskapp.network.model.Media;
import com.example.taskapp.network.model.Results;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArticlesHolder extends RecyclerView.ViewHolder {


    private Context mContext;
    private ImageView img_status;
    private Button btn_finish;

    private TextView txt_title, txt_details;
    private CircleImageView img;


    View view;


    public ArticlesHolder(View view) {
        super(view);


        txt_details = view.findViewById(R.id.txt_details);
        txt_title = view.findViewById(R.id.txt_title);
        img = view.findViewById(R.id.img);
        this.view = view;

    }

    public void bind(final Results article) {

        String title = article.getTitle();
        String articleAbstract = article.getAbstract();
        txt_title.setText((title.length() > 150) ? title.substring(0, 150).concat("....") : title);
        txt_details.setText((articleAbstract.length() > 150) ? articleAbstract.substring(0, 150).concat("...."):articleAbstract);

        loadImage(article);


    }

    private void loadImage(Results article) {
        if (article.getMedia().size() > 0) {
            List<Media.MediaMetadata> metadata = article.getMedia().get(0).getMediaMetadata();
            if (metadata != null && metadata.size() > 0)
                Picasso.with(img.getContext()).load(metadata.get(0).getUrl()).into(img);
        }
    }


}
